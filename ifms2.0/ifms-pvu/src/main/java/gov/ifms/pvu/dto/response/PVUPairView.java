package gov.ifms.pvu.dto.response;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

import java.io.Serializable;

@NativeQueryResultEntity
public class PVUPairView implements Serializable {

    @NativeQueryResultColumn(index = 0)
    private String key;

    @NativeQueryResultColumn(index = 1)
    private String value;


    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
