package edu.javacourse.studentorder.validator;

import edu.javacourse.studentorder.domain.wedding.AnswerWedding;
import edu.javacourse.studentorder.domain.StudentOrder;

public class WeddingValidator {
     public AnswerWedding checkWedding(StudentOrder studentOrder){
        System.out.println("Wedding is running");
        return new AnswerWedding();
    }
}
