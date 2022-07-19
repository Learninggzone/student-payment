package edu.javacourse.studentorder.validator.register;

import edu.javacourse.studentorder.domain.Adult;
import edu.javacourse.studentorder.domain.Child;
import edu.javacourse.studentorder.domain.register.CityRegisterResponse;
import edu.javacourse.studentorder.exception.TransportException;
import edu.javacourse.studentorder.domain.Person;
import edu.javacourse.studentorder.exception.CityRegisterException;

public class FakeCityRegisterChecker implements CityRegisterChecker{

    private static final String GOOD_1 = "1000";
    private static final String GOOD_2 = "2000";
    private static final String BAD_1 = "1001";
    private static final String BAD_2 = "2001";
    private static final String ERROR_1 = "1002";
    private static final String ERROR_2 = "2002";
    private static final String ERROR_T_1 = "1003";
    private static final String ERROR_T_2 = "2003";

    @Override
    public CityRegisterResponse checkPerson(Person person) throws CityRegisterException, TransportException {
        CityRegisterResponse checkerResponse = new CityRegisterResponse();
        if (person instanceof Adult){
            Adult adult = (Adult) person;
            String passportSeria = adult.getPassportSeria();
            if(passportSeria.equals(GOOD_1) || passportSeria.equals(GOOD_2)){
                checkerResponse.setExisting(true);
                checkerResponse.setTemporal(false);
            }
            if(passportSeria.equals(BAD_1) || passportSeria.equals(BAD_2)){
                checkerResponse.setExisting(false);
            }
            if(passportSeria.equals(ERROR_1) || passportSeria.equals(ERROR_2)){
                throw new CityRegisterException("1","Fake GRN error: " + passportSeria);
            }
            if(passportSeria.equals(ERROR_T_1) || passportSeria.equals(ERROR_T_2)){
                throw new TransportException("Fake Transport error: " + passportSeria);
            }
        }

        if(person instanceof Child){
            checkerResponse.setExisting(true);
            checkerResponse.setTemporal(true);
        }

//        System.out.println(person.getClass().getSimpleName()  + ":\n" + person);
        return checkerResponse;
    }
}
