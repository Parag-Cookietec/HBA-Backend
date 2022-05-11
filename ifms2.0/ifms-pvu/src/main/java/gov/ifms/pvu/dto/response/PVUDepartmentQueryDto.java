package gov.ifms.pvu.dto.response;

import java.util.Date;

public class PVUDepartmentQueryDto {

    private Date dateOfJoiningGOG;

    private Date dateOfRetirement;


    public PVUDepartmentQueryDto(Date dateOfJoiningGOG, Date dateOfRetirement) {
        this.dateOfJoiningGOG = dateOfJoiningGOG;
        this.dateOfRetirement = dateOfRetirement;
    }

    public Date getDateOfJoiningGOG() {
        return dateOfJoiningGOG;
    }

    public void setDateOfJoiningGOG(Date dateOfJoiningGOG) {
        this.dateOfJoiningGOG = dateOfJoiningGOG;
    }

    public Date getDateOfRetirement() {
        return dateOfRetirement;
    }

    public void setDateOfRetirement(Date dateOfRetirement) {
        this.dateOfRetirement = dateOfRetirement;
    }
}
