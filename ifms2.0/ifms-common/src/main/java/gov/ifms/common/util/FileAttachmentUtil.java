package gov.ifms.common.util;

import java.io.IOException;

import org.springframework.core.io.Resource;

public class FileAttachmentUtil {

	private FileAttachmentUtil(){
		super();
	}
	public static String getContentType(final Resource resource) throws IOException {
		String contentType;
		String fileExtension = com.google.common.io.Files.getFileExtension(resource.getFile().getAbsolutePath());
		
		switch (fileExtension.toLowerCase()) {
		case "csv":
			contentType = Constant.FILE_EXTENSION_CSV;
			break;
		case "txt":
			contentType = Constant.FILE_EXTENSION_TXT;
			break;
		case "png":
			contentType = Constant.FILE_EXTENSION_PNG;
			break;
		case "jpg":
		case "jpeg":
			contentType = Constant.FILE_EXTENSION_JPEG;
			break;
		case "pdf":
			contentType = Constant.FILE_EXTENSION_PDF;
			break;
		case "doc":
			contentType = Constant.FILE_EXTENSION_DOC;
			break;
		case "docx":
			contentType = Constant.FILE_EXTENSION_DOCX;
			break;
		case "xls":
			contentType = Constant.FILE_EXTENSION_XLS;
			break;
		case "xlsx":
			contentType = Constant.FILE_EXTENSION_XLXS;
			break;
		default:
			contentType = Constant.FILE_EXTENSION_OCTET_STREAM;

		}
		return contentType;
	}

}
