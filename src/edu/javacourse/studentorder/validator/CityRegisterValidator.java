package edu.javacourse.studentorder.validator;

import edu.javacourse.studentorder.domain.AnswerCityRegister;
import edu.javacourse.studentorder.domain.StudentOrder;
import edu.javacourse.studentorder.exception.CityRegisterException;

public class CityRegisterValidator {

    private CityRegisterChecker personChecker;

    public CityRegisterValidator(){
        this.personChecker = new RealCityRegisterChecker();
    }

    public AnswerCityRegister checkCityRegister(StudentOrder studentOrder){
        try{
            personChecker.checkPerson(studentOrder.getHusband());
            personChecker.checkPerson(studentOrder.getWife());
            personChecker.checkPerson(studentOrder.getChild());
        } catch(CityRegisterException exception){
            exception.printStackTrace();
        }

        AnswerCityRegister answer = new AnswerCityRegister();
        answer.success = false;
        return answer;
    }
}
