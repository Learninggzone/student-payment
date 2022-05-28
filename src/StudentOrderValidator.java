public class StudentOrderValidator {
    public static void main(String[] args) {
        checkAll();
    }

    static void checkAll(){
        while(true){
            StudentOrder studentOrder = readStudentOrder();
            if (studentOrder == null)
                break;
            AnswerCityRegister answerCityRegister = checkCityRegister(studentOrder);
            if (!answerCityRegister.success)
                break;
            AnswerWedding answerWedding = checkWedding(studentOrder);
            AnswerChildren answerChildren = checkChildren(studentOrder);
            AnswerStudent answerStudent = checkStudent(studentOrder);

            sendMail(studentOrder);
        }
    }

    static StudentOrder readStudentOrder(){
        StudentOrder studentOrder = new StudentOrder();
        return studentOrder;
    }

    static AnswerCityRegister checkCityRegister(StudentOrder studentOrder){
        CityRegisterValidator cityRegisterValidator1 = new CityRegisterValidator();
        cityRegisterValidator1.hostName = "host_1";
        CityRegisterValidator cityRegisterValidator2 = new CityRegisterValidator();
        cityRegisterValidator2.hostName = "host_2";
        AnswerCityRegister answerCityRegister1 = cityRegisterValidator1.checkCityRegister(studentOrder);
        AnswerCityRegister answerCityRegister2 = cityRegisterValidator2.checkCityRegister(studentOrder);
        return answerCityRegister1;
    }

    static AnswerWedding checkWedding(StudentOrder studentOrder){
        return new WeddingValidator().checkWedding(studentOrder);
    }

    static AnswerChildren checkChildren(StudentOrder studentOrder){
        return new ChildrenValidator().checkChildren(studentOrder);
    }

    static AnswerStudent checkStudent(StudentOrder studentOrder){
        return new StudentValidator().checkStudent(studentOrder);
    }

    static void sendMail(StudentOrder studentOrder){
        new MailSender().sendMail(studentOrder);
    }
}
