package gov.ifms.doi.jpa.dto;

import java.util.List;
import java.util.Objects;

public class MasterEntryDTO {

    public List<DoiJpaSchemeMasterDTO> dto;

    public List<DoiJpaSchemeMasterDTO> getDto() {
        return dto;
    }

    public void setDto(List<DoiJpaSchemeMasterDTO> dto) {
        this.dto = dto;
    }

    @Override
    public String toString() {
        return "MasterEntryDTO{" +
                "dto=" + dto +
                '}';
    }
}
