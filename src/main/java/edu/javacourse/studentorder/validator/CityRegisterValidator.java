package edu.javacourse.studentorder.validator;

import edu.javacourse.studentorder.domain.Child;
import edu.javacourse.studentorder.domain.Person;
import edu.javacourse.studentorder.domain.register.AnswerCityRegister;
import edu.javacourse.studentorder.domain.register.AnswerCityRegisterItem;
import edu.javacourse.studentorder.domain.register.CityRegisterResponse;
import edu.javacourse.studentorder.exception.TransportException;
import edu.javacourse.studentorder.domain.StudentOrder;
import edu.javacourse.studentorder.exception.CityRegisterException;
import edu.javacourse.studentorder.validator.register.CityRegisterChecker;
import edu.javacourse.studentorder.validator.register.FakeCityRegisterChecker;

public class CityRegisterValidator {

    private CityRegisterChecker personChecker;
    private static final String IN_CODE = "NO_GRN";

    public CityRegisterValidator(){
        this.personChecker = new FakeCityRegisterChecker();
    }

    public AnswerCityRegister checkCityRegister(StudentOrder studentOrder){
        AnswerCityRegister answerCityRegister = new AnswerCityRegister();

        answerCityRegister.addItem(checkPerson(studentOrder.getHusband()));
        answerCityRegister.addItem(checkPerson(studentOrder.getWife()));
        for (Child child: studentOrder.getChildren())
            answerCityRegister.addItem(checkPerson(child));

        return answerCityRegister;
    }

    private AnswerCityRegisterItem checkPerson(Person person) {

        AnswerCityRegisterItem.CityStatus status;
        AnswerCityRegisterItem.CityError error = null;

        try {
            CityRegisterResponse response = personChecker.checkPerson(person);
            status = response.isExisting() ?
                    AnswerCityRegisterItem.CityStatus.YES :
                    AnswerCityRegisterItem.CityStatus.NO;
        } catch(CityRegisterException exception){
            exception.printStackTrace();
            status = AnswerCityRegisterItem.CityStatus.ERROR;
            error = new AnswerCityRegisterItem.CityError(exception.getCode(), exception.getMessage());
        } catch (TransportException exception){
            exception.printStackTrace();
            status = AnswerCityRegisterItem.CityStatus.ERROR;
            error = new AnswerCityRegisterItem.CityError(IN_CODE, exception.getMessage());
        }

        AnswerCityRegisterItem item = new AnswerCityRegisterItem(status, person, error);
        System.out.println(item);
        return item;
    }
}
