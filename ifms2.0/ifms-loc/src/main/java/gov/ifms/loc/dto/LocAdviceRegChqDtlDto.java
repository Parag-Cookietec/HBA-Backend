package gov.ifms.loc.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@NativeQueryResultEntity
public class LocAdviceRegChqDtlDto {


        /** The chq ser start. */
        @NativeQueryResultColumn(index = 0)
        private String chqSerStart;

        /** The chq series end. */
        @NativeQueryResultColumn(index = 1)
        private String chqSeriesEnd;

    @NativeQueryResultColumn(index = 2)
    private String chqTochqData;

        /** The last chq no. */
        private String lastChqNo;

        /** The new chq no. */
        private String newChqNo;

        /** The next chq series. */
        private List<LocAdviceRegChqDtlDto> nextChqSeries;

    public String getChqSerStart() {
        return chqSerStart;
    }

    public void setChqSerStart(String chqSerStart) {
        this.chqSerStart = chqSerStart;
    }

    public String getChqSeriesEnd() {
        return chqSeriesEnd;
    }

    public void setChqSeriesEnd(String chqSeriesEnd) {
        this.chqSeriesEnd = chqSeriesEnd;
    }

    public String getChqTochqData() {
        return chqTochqData;
    }

    public void setChqTochqData(String chqTochqData) {
        this.chqTochqData = chqTochqData;
    }

    public String getLastChqNo() {
        return lastChqNo;
    }

    public void setLastChqNo(String lastChqNo) {
        this.lastChqNo = lastChqNo;
    }

    public String getNewChqNo() {
        return newChqNo;
    }

    public void setNewChqNo(String newChqNo) {
        this.newChqNo = newChqNo;
    }

    public List<LocAdviceRegChqDtlDto> getNextChqSeries() {
        return nextChqSeries;
    }

    public void setNextChqSeries(List<LocAdviceRegChqDtlDto> nextChqSeries) {
        this.nextChqSeries = nextChqSeries;
    }
}
