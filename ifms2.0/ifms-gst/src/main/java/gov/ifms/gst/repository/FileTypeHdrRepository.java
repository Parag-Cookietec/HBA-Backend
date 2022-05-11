package gov.ifms.gst.repository;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.gst.entity.FileTypeHdr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface FileTypeHdrRepository
		extends JpaRepository<FileTypeHdr, Long>, JpaSpecificationExecutor<FileTypeHdr>, GenericDao {

	FileTypeHdr findByFileTypeCd(String fileTypeCd);

}
