package gov.ifms.common.dto;

import java.io.Serializable;
import java.util.List;

public class ConditionDto implements Serializable {

    private long trnId;

    private List<String> condition;

    private String  defaultCondition;

    public long getTrnId() {
        return trnId;
    }

    public void setTrnId(long trnId) {
        this.trnId = trnId;
    }

    public List<String> getCondition() {
        return condition;
    }

    public void setCondition(List<String> condition) {
        this.condition = condition;
    }

    public String getDefaultCondition() {
        return defaultCondition;
    }

    public void setDefaultCondition(String defaultCondition) {
        this.defaultCondition = defaultCondition;
    }
}
