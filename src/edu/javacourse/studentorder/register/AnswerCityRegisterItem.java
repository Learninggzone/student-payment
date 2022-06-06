package edu.javacourse.studentorder.register;

import edu.javacourse.studentorder.domain.Person;

public class AnswerCityRegisterItem {

    public enum CityStatus {
        YES, NO, ERROR;
    }

    public static class CityError{
        private String errorCode;
        private String errorMessage;

        public CityError(String errorCode, String errorMessage) {
            this.errorCode = errorCode;
            this.errorMessage = errorMessage;
        }

        public String getErrorCode() {
            return errorCode;
        }

        public void setErrorCode(String errorCode) {
            this.errorCode = errorCode;
        }

        public String getErrorMessage() {
            return errorMessage;
        }

        public void setErrorMessage(String errorMessage) {
            this.errorMessage = errorMessage;
        }

        @Override
        public String toString() {
            return "CityError{" +
                    "errorCode='" + errorCode + '\'' +
                    ", errorMessage='" + errorMessage + '\'' +
                    '}';
        }
    }

    private Person person;
    private CityStatus cityStatus;
    private CityError cityError;

    public AnswerCityRegisterItem(Person person, CityStatus cityStatus) {
        this.person = person;
        this.cityStatus = cityStatus;
    }

    public AnswerCityRegisterItem(Person person, CityStatus cityStatus, CityError cityError) {
        this.person = person;
        this.cityStatus = cityStatus;
        this.cityError = cityError;
    }

    public Person getPerson() {
        return person;
    }

    public CityStatus getCityStatus() {
        return cityStatus;
    }

    public CityError getCityError() {
        return cityError;
    }

    @Override
    public String toString() {
        return "AnswerCityRegisterItem{" +
                "person=" + person +
                ", cityStatus=" + cityStatus +
                ", cityError=" + cityError +
                '}';
    }
}
