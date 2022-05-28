package edu.javacourse.studentorder;

import edu.javacourse.studentorder.domain.Adult;
import edu.javacourse.studentorder.domain.Person;
import edu.javacourse.studentorder.domain.StudentOrder;

public class SaveStudentOrder {
    public static void main(String[] args) {
        buildStudentOrder();
    }

    static void scheduleStudentOrder(){
        System.out.println("Schedule is running");
    }

    static void financeStudentOrder(){
        System.out.println("Finance is running");
    }

    static long saveStudentOrder(StudentOrder studentOrder){
        long answer = 199;
        System.out.println("Save student order");
        return answer;
    }

   static StudentOrder buildStudentOrder() {
        StudentOrder studentOrder = new StudentOrder();
        Adult husband = new Adult();
        husband.setFirstname("Andrei");
        return studentOrder;
    }
}
