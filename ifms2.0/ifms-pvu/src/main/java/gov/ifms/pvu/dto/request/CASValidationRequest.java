package gov.ifms.pvu.dto.request;

import java.time.LocalDate;
import java.util.Objects;
import java.util.StringJoiner;

import javax.validation.constraints.NotNull;

public class CASValidationRequest {
	
	@NotNull
    private Long employeeId;

    @NotNull
    private LocalDate effectiveDate;

    private Long employeeClassId;

    public CASValidationRequest(@NotNull Long employeeId, @NotNull LocalDate effectiveDate, Long employeeClassId) {
        this.employeeId = employeeId;
        this.effectiveDate = effectiveDate;
        this.employeeClassId = employeeClassId;
    }

    public CASValidationRequest() {
    }

    /**
     * Getter for property 'employeeId'.
     *
     * @return Value for property 'employeeId'.
     */
    public Long getEmployeeId() {
        return employeeId;
    }

    /**
     * Setter for property 'employeeId'.
     *
     * @param employeeId Value to set for property 'employeeId'.
     */
    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * Getter for property 'effectiveDate'.
     *
     * @return Value for property 'effectiveDate'.
     */
    public LocalDate getEffectiveDate() {
        return effectiveDate;
    }

    /**
     * Setter for property 'effectiveDate'.
     *
     * @param effectiveDate Value to set for property 'effectiveDate'.
     */
    public void setEffectiveDate(LocalDate effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    /**
     * Getter for property 'employeeClassId'.
     *
     * @return Value for property 'employeeClassId'.
     */
    public Long getEmployeeClassId() {
        return employeeClassId;
    }

    /**
     * Setter for property 'employeeClassId'.
     *
     * @param employeeClassId Value to set for property 'employeeClassId'.
     */
    public void setEmployeeClassId(Long employeeClassId) {
        this.employeeClassId = employeeClassId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CASValidationRequest)) return false;
        CASValidationRequest that = (CASValidationRequest) o;
        return Objects.equals(employeeId, that.employeeId) &&
                Objects.equals(effectiveDate, that.effectiveDate) &&
                Objects.equals(employeeClassId, that.employeeClassId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, effectiveDate, employeeClassId);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CASValidationRequest.class.getSimpleName() + "[", "]")
                .add("employeeId=" + employeeId)
                .add("effectiveDate=" + effectiveDate)
                .add("employeeClassId=" + employeeClassId)
                .toString();
    }

}
