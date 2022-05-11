package gov.ifms.pvu.common;

import java.util.ArrayList;
import java.util.List;

/**
 * The Class BasePVUAttachmentDto.
 */
public class BasePVUAttachmentDtoList<D extends BasePVUAttachmentDto> {

    private List<D> objList = null;

    public List<D> getObjList() {
        return objList;
    }

    public void setObjList(List<D> objList) {
        this.objList = objList;
    }

    public BasePVUAttachmentDtoList() {
        objList = new ArrayList<>();
    }
}
