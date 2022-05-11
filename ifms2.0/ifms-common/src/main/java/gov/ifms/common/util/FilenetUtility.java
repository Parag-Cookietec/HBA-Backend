package gov.ifms.common.util;

import java.io.*;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.security.auth.Subject;

import gov.ifms.common.attachment.dto.AttachmentCommonDto;
import gov.ifms.common.exception.CustomException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.filenet.api.collection.ContentElementList;
import com.filenet.api.collection.RepositoryRowSet;
import com.filenet.api.constants.AutoClassify;
import com.filenet.api.constants.AutoUniqueName;
import com.filenet.api.constants.CheckinType;
import com.filenet.api.constants.ClassNames;
import com.filenet.api.constants.DefineSecurityParentage;
import com.filenet.api.constants.PropertyNames;
import com.filenet.api.constants.RefreshMode;
import com.filenet.api.core.Connection;
import com.filenet.api.core.ContentTransfer;
import com.filenet.api.core.Document;
import com.filenet.api.core.Domain;
import com.filenet.api.core.DynamicReferentialContainmentRelationship;
import com.filenet.api.core.Factory;
import com.filenet.api.core.Folder;
import com.filenet.api.core.ObjectStore;
import com.filenet.api.core.UpdatingBatch;
import com.filenet.api.exception.EngineRuntimeException;
import com.filenet.api.exception.ExceptionCode;
import com.filenet.api.property.FilterElement;
import com.filenet.api.property.PropertyFilter;
import com.filenet.api.query.SearchSQL;
import com.filenet.api.query.SearchScope;
import com.filenet.api.util.Id;
import com.filenet.api.util.UserContext;

import gov.ifms.common.attachment.dto.FileUploadResponseDto;

@Component
public class FilenetUtility {
	private static Logger logger = LoggerFactory.getLogger(FilenetUtility.class);

	/** The ce uri. */
	private static String ceUri;

	/** The user id. */
	public static String userId;

	/** The password. */
	public static String password;

	/** The object store name. */
	public static String objectStoreName;

	/**
	 * Sets the ce uri.
	 *
	 * @param ceUri the new ce uri
	 */
	@Value("${filenet.url}")
	public synchronized void setCeUri(String ceUri1) {
		FilenetUtility.ceUri = ceUri1;
	}

	/**
	 * Sets the user id.
	 *
	 * @param userId the new user id
	 */
	@Value("${filenet.userid}")
	public synchronized void setUserId(String userId) {
		FilenetUtility.userId = userId;
	}

	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	@Value("${filenet.password}")
	public synchronized void setPassword(String password) {
		FilenetUtility.password = password;
	}

	/**
	 * Sets the object store name.
	 *
	 * @param objectStoreName the new object store name
	 */
	@Value("${filenet.object.store}")
	public synchronized void setObjectStoreName(String objectStoreName) {
		FilenetUtility.objectStoreName = objectStoreName;
	}

	/** The con. */
	private static Connection con = null;

	/**
	 * Gets the single instance of FilenetUtil.
	 *
	 * @return single instance of FilenetUtil
	 */
	public static Connection getInstance() {
		if (null == con)
			con = Factory.Connection.getConnection(ceUri);
		return con;
	}

	/**
	 * Gets the domain.
	 *
	 * @param userId     the user id
	 * @param password   the password
	 * @param jaasStanza the jaas stanza
	 * @return the domain
	 */
	public static Domain getDomain(String userId, String password) {
		Connection con = getInstance();
		Subject subject = UserContext.createSubject(con, userId, password, "FileNetP8WSI");
		UserContext uc = UserContext.get();
		uc.pushSubject(subject);
		return Factory.Domain.getInstance(con, null);
	}

	/**
	 * Gets the object store.
	 *
	 * @param domain          the domain
	 * @param objectStoreName the object store name
	 * @return the object store
	 */
	public static ObjectStore getObjectStore(Domain domain, String objectStoreName) {
		return Factory.ObjectStore.fetchInstance(domain, objectStoreName, null);
	}

	/**
	 * Gets the content type.
	 *
	 * @param fileType the file type
	 * @return the content type
	 */
	public static String getContentType(String fileType) {
		String contentType = "";
		switch (fileType) {
		case "pdf":
			contentType = "application/pdf";
			break;
		case "xls":
			contentType = "application/vnd.ms-excel";
			break;
		case "xlsx":
			contentType = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
			break;
		case "doc":
			contentType = "application/msword";
			break;
		case "docx":
			contentType = "application/vnd.openxmlformats-officedocument.wordprocessingml.document";
			break;
		case "jpg":
		case "jpeg":
			contentType = "image/jpeg";
			break;
		case "png":
			contentType = "image/png";
			break;
		default:
			contentType = "application/octet-stream";
		}
		return contentType;
	}

	/**
	 * Builds the upload path.
	 *
	 * @param uploadLocation the upload location
	 * @param os             the os
	 * @return the string
	 */
	public static String buildUploadPath(final String uploadLocation, final ObjectStore os) {
		StringBuilder fullParentPath = new StringBuilder();
		int i = 1;
		try {
			for (String fld : uploadLocation.split(Constant.BACK_SLASH)) {
				if (fld == null || fld.isEmpty()) {
					continue;
				}
				if (i == 1) {
					if (!isFolderExists(os, fld, null, false)) {
						createFolder(os, File.separator + fld, null);
					}
					i++;
				} else {
					if (!isFolderExists(os, fullParentPath.toString(), fld, true)) {
						createFolder(os, fld, fullParentPath.toString());
					}
				}
				fullParentPath.append(File.separator).append(fld);
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
		}
		return fullParentPath.toString();
	}

	/**
	 * Upload document.
	 *
	 * @param file the file
	 * @throws FileNotFoundException the file not found exception
	 */
	@SuppressWarnings("unchecked")
	public static List<FileUploadResponseDto> uploadDocument(final List<File> files, final String uploadLocation)
			throws FileNotFoundException {

		Domain dom = getDomain(userId, password);
		ObjectStore os = getObjectStore(dom, objectStoreName);
		if (!isFolderExists(os, uploadLocation.substring(0, uploadLocation.lastIndexOf(Constant.BACK_SLASH)),
				uploadLocation.substring(uploadLocation.lastIndexOf(Constant.BACK_SLASH) + 1), true)) {
			buildUploadPath(uploadLocation, os);
		}

		final StringBuilder uploadPathBuilder = new StringBuilder();
		List<FileUploadResponseDto> fileUploadResponseDtos = new ArrayList<>();
		for (File file : files) {
			String fileName = file.getName();
			String containmentName = fileName.substring(0, fileName.lastIndexOf(Constant.DOT));
			String fileType = fileName.substring(fileName.lastIndexOf(Constant.DOT) + 1);
			String contentType = getContentType(fileType);

			FileInputStream fin = new FileInputStream(file);
			ContentTransfer ct = Factory.ContentTransfer.createInstance();
			ct.setCaptureSource(fin);
			ct.set_RetrievalName(fileName);
			ct.set_ContentType(contentType);

			ContentElementList cel = Factory.ContentElement.createList();
			cel.add(ct);

			Document doc = Factory.Document.createInstance(os, null);
		    doc.getProperties().putValue(Constant.DOCUMENT_TITLE, fileName);
			doc.set_ContentElements(cel);
			doc.checkin(AutoClassify.DO_NOT_AUTO_CLASSIFY, CheckinType.MAJOR_VERSION);
			/** Set the storage folder **/
			Folder folder = Factory.Folder.getInstance(os, null, uploadLocation);

			/** Store the actual object to store **/
			DynamicReferentialContainmentRelationship rcr = Factory.DynamicReferentialContainmentRelationship
					.createInstance(os, null, AutoUniqueName.AUTO_UNIQUE,
							DefineSecurityParentage.DO_NOT_DEFINE_SECURITY_PARENTAGE);
			rcr.set_Tail(folder);
			rcr.set_Head(doc);
			rcr.set_ContainmentName(containmentName);

			UpdatingBatch ub = UpdatingBatch.createUpdatingBatchInstance(dom, RefreshMode.REFRESH);
			ub.add(doc, null);
			ub.add(rcr, null);
			ub.updateBatch();
			uploadPathBuilder.append(uploadLocation);
			uploadPathBuilder.append(Constant.BACK_SLASH);
			uploadPathBuilder.append(doc.get_Name());

			FileUploadResponseDto uploadResponseDto = new FileUploadResponseDto();
			uploadResponseDto.setFilename(doc.get_Name());
			uploadResponseDto.setDocumentId(doc.get_Id().toString());
			uploadResponseDto.setUploadDirPath(uploadPathBuilder.toString());
			fileUploadResponseDtos.add(uploadResponseDto);
			uploadPathBuilder.setLength(0);

		}
		return fileUploadResponseDtos;
	}

	/**
	 * Checks if is folder exists.
	 *
	 * @param os               the os
	 * @param parentFolderName the parent folder name
	 * @param subFolderName    the sub folder name
	 * @param subFolder        the sub folder
	 * @return true, if is folder exists
	 */
	public static boolean isFolderExists(ObjectStore os, String parentFolderName, String subFolderName,
			boolean subFolder) {

		final StringBuilder queryBuilder = new StringBuilder("SELECT FolderName FROM Folder WHERE FolderName='");
		queryBuilder.append((subFolder ? subFolderName : parentFolderName));
		queryBuilder.append(Constant.QUERY_PARAMETER_MARKER);

		if (subFolder) {
			queryBuilder.append("AND Parent = Object('");
			queryBuilder.append(parentFolderName);
			queryBuilder.append("')");
		}
		SearchSQL sqlObject = new SearchSQL();
		sqlObject.setQueryString(queryBuilder.toString());

		// The SearchSQL instance (sqlObject) can then be specified in the
		// SearchScope parameter list to execute the search. Uses fetchRows to test the
		// SQL
		// statement.
		SearchScope searchScope = new SearchScope(os);
		RepositoryRowSet rowSet = searchScope.fetchRows(sqlObject, null, null, Boolean.TRUE);
		return !rowSet.isEmpty();
	}

	/**
	 * Creates the folder.
	 *
	 * @param os           the os
	 * @param folderName   the folder name
	 * @param parentFolder the parent folder
	 * @return the folder
	 */
	public static Folder createFolder(ObjectStore os, String folderName, String parentFolder) {
		Folder folder = null;
		try {
			folder = Factory.Folder.createInstance(os, null);
			Folder rootFolder = Factory.Folder.getInstance(os, null,
					(parentFolder == null ? folderName : parentFolder));
			folder.set_Parent(rootFolder);
			folder.set_FolderName(folderName);
			folder.save(RefreshMode.NO_REFRESH);

		} catch (EngineRuntimeException ere) {
			// Create failed. See if it's because the folder exists.

			ExceptionCode code = ere.getExceptionCode();
			if (code != ExceptionCode.E_NOT_UNIQUE) {
				throw ere;
			}
			folder = Factory.Folder.getInstance(os, null, File.separator + parentFolder + File.separator + folderName);
		}
		return folder;
	}

	/**
	 *
	 * @param id document id.
	 * @return InputStreamResource
	 * @throws IOException
	 */
	public static Document retrieveDocument(Id id) {

		Domain dom = getDomain(userId, password);
		ObjectStore os = getObjectStore(dom, objectStoreName);
		// Get document and populate property cache.
		PropertyFilter pf = new PropertyFilter();
     	pf.addIncludeProperty(new FilterElement(null, null, null, Constant.DOCUMENT_TITLE, null));
		pf.addIncludeProperty(new FilterElement(null, null, null, PropertyNames.MIME_TYPE, null));
		Document doc = Factory.Document.getInstance(os, ClassNames.DOCUMENT, id);
		// Fetch selected properties from the server.
		doc.fetchProperties(pf);
		doc.refresh(new String[] { PropertyNames.CONTENT_ELEMENTS });
		return doc;
	}

	public static List<FileUploadResponseDto> uploadDocs(List<MultipartFile> attachment, String uploadLocation)
			throws IOException {
		Domain dom = getDomain(userId, password);
		ObjectStore os = getObjectStore(dom, objectStoreName);
		if (!isFolderExists(os, uploadLocation.substring(0, uploadLocation.lastIndexOf(Constant.BACK_SLASH)),
				uploadLocation.substring(uploadLocation.lastIndexOf(Constant.BACK_SLASH) + 1), true)) {
			buildUploadPath(uploadLocation, os);
		}
		final StringBuilder uploadPathBuilder = new StringBuilder();
		List<FileUploadResponseDto> fileUploadResponseDtos = new ArrayList<>();
		for (MultipartFile multiFile : attachment) {

			String fileName = multiFile.getOriginalFilename();
			String containmentName = fileName.substring(0, fileName.lastIndexOf(Constant.DOT));
			String fileType = fileName.substring(fileName.lastIndexOf(Constant.DOT) + 1);
			String contentType = getContentType(fileType);
			BufferedInputStream inputStream = new BufferedInputStream(multiFile.getInputStream());
			ContentTransfer ct = Factory.ContentTransfer.createInstance();
			ct.setCaptureSource(inputStream);
			ct.set_RetrievalName(fileName);
			ct.set_ContentType(contentType);

			ContentElementList cel = Factory.ContentElement.createList();
			cel.add(ct);

			Document doc = Factory.Document.createInstance(os, null);
	        doc.getProperties().putValue(Constant.DOCUMENT_TITLE, fileName);
			doc.set_ContentElements(cel);
			doc.checkin(AutoClassify.DO_NOT_AUTO_CLASSIFY, CheckinType.MAJOR_VERSION);
			/** Set the storage folder **/
			Folder folder = Factory.Folder.getInstance(os, null, uploadLocation);

			/** Store the actual object to store **/
			DynamicReferentialContainmentRelationship rcr = Factory.DynamicReferentialContainmentRelationship
					.createInstance(os, null, AutoUniqueName.AUTO_UNIQUE,
							DefineSecurityParentage.DO_NOT_DEFINE_SECURITY_PARENTAGE);
			rcr.set_Tail(folder);
			rcr.set_Head(doc);
			rcr.set_ContainmentName(containmentName);

			UpdatingBatch ub = UpdatingBatch.createUpdatingBatchInstance(dom, RefreshMode.REFRESH);
			ub.add(doc, null);
			ub.add(rcr, null);
			ub.updateBatch();
			uploadPathBuilder.append(uploadLocation);
			uploadPathBuilder.append(Constant.BACK_SLASH);
			uploadPathBuilder.append(doc.get_Name());

			FileUploadResponseDto uploadResponseDto = new FileUploadResponseDto();
			uploadResponseDto.setFilename(doc.get_Name());
			uploadResponseDto.setDocumentId(doc.get_Id().toString());
			uploadResponseDto.setUploadDirPath(uploadPathBuilder.toString());
			fileUploadResponseDtos.add(uploadResponseDto);
			uploadPathBuilder.setLength(0);
		}
		return fileUploadResponseDtos;
	}


	public static String convertFilenetDocumentIntoBase64String(InputStream inoutStream) throws IOException, CustomException {
		byte[] bytes = toByteArray(inoutStream);
		return Base64.getEncoder().encodeToString(bytes);
	}

	/**
	 * To byte array.
	 *
	 * @param in the in
	 * @return the byte[]
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws CustomException
	 */
	public static byte[] toByteArray(InputStream in) throws IOException, CustomException {

		try(ByteArrayOutputStream os = new ByteArrayOutputStream()){
			byte[] buffer = new byte[2000000];
			int len;

            // 	read bytes from the input stream and store them in buffer
            while ((len = in.read(buffer)) != -1) {
                // write bytes from the buffer into output stream
                os.write(buffer, 0, len);
            }
            return os.toByteArray();
        } catch (Exception e) {
            throw new CustomException(ErrorResponse.UNKNOWN_ERROR_OCCURED);
        }
    }


    public static AttachmentCommonDto uploadSINGLEDocs(MultipartFile multiFile, String uploadLocation, AttachmentCommonDto attachmentCommonDto)
            throws IOException {
        Domain dom = getDomain(userId, password);
        ObjectStore os = getObjectStore(dom, objectStoreName);
        if (!isFolderExists(os, uploadLocation.substring(0, uploadLocation.lastIndexOf(Constant.BACK_SLASH)),
                uploadLocation.substring(uploadLocation.lastIndexOf(Constant.BACK_SLASH) + 1), true)) {
            buildUploadPath(uploadLocation, os);
        }
        final StringBuilder uploadPathBuilder = new StringBuilder();
        String fileName = multiFile.getOriginalFilename();
        String containmentName = fileName.substring(0, fileName.lastIndexOf(Constant.DOT));
        String fileType = fileName.substring(fileName.lastIndexOf(Constant.DOT) + 1);
        String contentType = getContentType(fileType);
        BufferedInputStream inputStream = new BufferedInputStream(multiFile.getInputStream());
        ContentTransfer ct = Factory.ContentTransfer.createInstance();
        ct.setCaptureSource(inputStream);
        ct.set_RetrievalName(fileName);
        ct.set_ContentType(contentType);
        ContentElementList cel = Factory.ContentElement.createList();
        cel.add(ct);
        Document doc = Factory.Document.createInstance(os, null);
        doc.getProperties().putValue(Constant.DOCUMENT_TITLE, fileName);
        doc.set_ContentElements(cel);
        doc.checkin(AutoClassify.DO_NOT_AUTO_CLASSIFY, CheckinType.MAJOR_VERSION);
        /** Set the storage folder **/
        Folder folder = Factory.Folder.getInstance(os, null, uploadLocation);
        /** Store the actual object to store **/
        DynamicReferentialContainmentRelationship rcr = Factory.DynamicReferentialContainmentRelationship
                .createInstance(os, null, AutoUniqueName.AUTO_UNIQUE,
                        DefineSecurityParentage.DO_NOT_DEFINE_SECURITY_PARENTAGE);
        rcr.set_Tail(folder);
        rcr.set_Head(doc);
        rcr.set_ContainmentName(containmentName);
        UpdatingBatch ub = UpdatingBatch.createUpdatingBatchInstance(dom, RefreshMode.REFRESH);
        ub.add(doc, null);
        ub.add(rcr, null);
        ub.updateBatch();
        uploadPathBuilder.append(uploadLocation);
        uploadPathBuilder.append(Constant.BACK_SLASH);
        uploadPathBuilder.append(doc.get_Name());
        attachmentCommonDto.setDocumentId(doc.get_Id().toString());
        attachmentCommonDto.setUploadDirectoryPath(uploadPathBuilder.toString());
        return attachmentCommonDto;
    }
}
