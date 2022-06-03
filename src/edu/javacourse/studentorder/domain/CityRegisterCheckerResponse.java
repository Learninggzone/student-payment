package edu.javacourse.studentorder.domain;

public class CityRegisterCheckerResponse {
    private boolean success;
    private Boolean temporal;

    public CityRegisterCheckerResponse() {
    }

    public CityRegisterCheckerResponse(boolean success, Boolean temporal) {
        this.success = success;
        this.temporal = temporal;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Boolean getTemporal() {
        return temporal;
    }

    public void setTemporal(Boolean temporal) {
        this.temporal = temporal;
    }

    @Override
    public String toString() {
        return "CityRegisterCheckerResponse{" +
                "success=" + success +
                ", temporal=" + temporal +
                '}';
    }
}
