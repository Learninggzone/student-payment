public class CityRegisterValidator {

    String hostName;

    AnswerCityRegister checkCityRegister(StudentOrder studentOrder){
        System.out.println("City register is running with host: " + hostName);
        AnswerCityRegister answer = new AnswerCityRegister();
        answer.success = false;
        return answer;
    }
}
