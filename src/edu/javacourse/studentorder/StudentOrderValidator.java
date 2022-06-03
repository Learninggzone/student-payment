package edu.javacourse.studentorder;

import edu.javacourse.studentorder.domain.*;
import edu.javacourse.studentorder.mail.MailSender;
import edu.javacourse.studentorder.validator.ChildrenValidator;
import edu.javacourse.studentorder.validator.CityRegisterValidator;
import edu.javacourse.studentorder.validator.StudentValidator;
import edu.javacourse.studentorder.validator.WeddingValidator;

public class StudentOrderValidator {

    private CityRegisterValidator cityRegisterValidator;
    private WeddingValidator weddingValidator;
    private ChildrenValidator childrenValidator;
    private StudentValidator studentValidator;
    private MailSender mailSender;

    public StudentOrderValidator(){
        cityRegisterValidator = new CityRegisterValidator();
        weddingValidator = new WeddingValidator();
        childrenValidator = new ChildrenValidator();
        studentValidator = new StudentValidator();
        mailSender = new MailSender();
    }

    public static void main(String[] args) {
        StudentOrderValidator studentOrderValidator = new StudentOrderValidator();
        studentOrderValidator.checkAll();
    }

    public void checkAll(){
        StudentOrder[] studentOrderArr = readStudentOrder();

        for(StudentOrder studentOrder: studentOrderArr)
            checkOneOrder(studentOrder);
    }

    public void checkOneOrder(StudentOrder studentOrder){
        AnswerCityRegister answerCityRegister = checkCityRegister(studentOrder);
//        AnswerWedding answerWedding = checkWedding(studentOrder);
//        AnswerChildren answerChildren = checkChildren(studentOrder);
//        AnswerStudent answerStudent = checkStudent(studentOrder);
//        sendMail(studentOrder);
    }

    public StudentOrder[] readStudentOrder(){
        StudentOrder[] studentOrderArr = new StudentOrder[3];
        for (int i = 0; i < studentOrderArr.length; i++)
            studentOrderArr[i] = SaveStudentOrder.buildStudentOrder(i);
        return studentOrderArr;
    }

    public AnswerCityRegister checkCityRegister(StudentOrder studentOrder){
        return cityRegisterValidator.checkCityRegister(studentOrder);
    }

    public AnswerWedding checkWedding(StudentOrder studentOrder){
        return weddingValidator.checkWedding(studentOrder);
    }

    public AnswerChildren checkChildren(StudentOrder studentOrder){
        return childrenValidator.checkChildren(studentOrder);
    }

    public AnswerStudent checkStudent(StudentOrder studentOrder){
        return studentValidator.checkStudent(studentOrder);
    }

    public void sendMail(StudentOrder studentOrder){
        mailSender.sendMail(studentOrder);
    }
}
