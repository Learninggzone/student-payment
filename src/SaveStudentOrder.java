public class SaveStudentOrder {
    public static void main(String[] args) {
        System.out.println("Save student order");
        StudentOrder studentOrder1 = new StudentOrder();
        studentOrder1.hFirstName = "Alexey";
        studentOrder1.hLastName = "Petrov";
        studentOrder1.wFirstName = "Mariya";
        studentOrder1.hFirstName = "Petrova";

        StudentOrder studentOrder2 = new StudentOrder();
        studentOrder2.hFirstName = "Pavel";
        studentOrder2.hLastName = "Zhukov";
        studentOrder2.wFirstName = "Nataliya";
        studentOrder2.hFirstName = "Zhukova";

        long studentOrder1Answer = saveStudentOrder(studentOrder1);
        long studentOrder2Answer = saveStudentOrder(studentOrder2);
    }

    static void scheduleStudentOrder(){
        System.out.println("Schedule is running");
    }

    static void financeStudentOrder(){
        System.out.println("Finance is running");
    }

    static long saveStudentOrder(StudentOrder studentOrder){
        long answer = 199;
        System.out.println("StudentOrder hFirstName" + studentOrder.hFirstName);
        return answer;
    }
}
