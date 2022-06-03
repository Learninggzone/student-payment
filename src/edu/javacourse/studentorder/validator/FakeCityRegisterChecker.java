package edu.javacourse.studentorder.validator;

import edu.javacourse.studentorder.domain.Adult;
import edu.javacourse.studentorder.domain.Child;
import edu.javacourse.studentorder.domain.CityRegisterCheckerResponse;
import edu.javacourse.studentorder.domain.Person;
import edu.javacourse.studentorder.exception.CityRegisterException;

public class FakeCityRegisterChecker implements CityRegisterChecker{

    private static final String GOOD_1 = "1000";
    private static final String GOOD_2 = "2000";
    private static final String BAD_1 = "1001";
    private static final String BAD_2 = "2001";
    private static final String ERROR_1 = "1002";
    private static final String ERROR_2 = "2002";

    @Override
    public CityRegisterCheckerResponse checkPerson(Person person) throws CityRegisterException{
        CityRegisterCheckerResponse checkerResponse = new CityRegisterCheckerResponse();
        if (person instanceof Adult){
            Adult adult = (Adult) person;
            if(adult.getPassportSeria().equals(GOOD_1) || adult.getPassportSeria().equals(GOOD_2)){
                checkerResponse.setSuccess(true);
                checkerResponse.setTemporal(false);
            }
            if(adult.getPassportSeria().equals(BAD_1) || adult.getPassportSeria().equals(BAD_2)){
                checkerResponse.setSuccess(false);
            }
            if(adult.getPassportSeria().equals(ERROR_1) || adult.getPassportSeria().equals(ERROR_2)){
                throw new CityRegisterException("Fake error!");
            }
        }

        if(person instanceof Child){
            checkerResponse.setSuccess(true);
            checkerResponse.setTemporal(true);
        }

        System.out.println(person.getClass().getSimpleName()  + ":\n" + checkerResponse);
        return checkerResponse;
    }
}
