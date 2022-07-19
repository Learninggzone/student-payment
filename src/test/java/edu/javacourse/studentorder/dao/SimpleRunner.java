package edu.javacourse.studentorder.dao;


import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class SimpleRunner {
    public static void main(String[] args) {
        SimpleRunner simpleRunner = new SimpleRunner();
        simpleRunner.runTests();
    }

    /*
    Loads Test class by reflection, and runs all methods containing @Test annotation
     */

    private void runTests(){
        try {
            Class cl = Class.forName("edu.javacourse.studentorder.dao.DictionaryDaoImplTest");
            Constructor constructor = cl.getConstructor();
            Object object = constructor.newInstance();
            Method[] methods = cl.getMethods();
            for (Method method: methods){
                Test testClass = method.getAnnotation(Test.class);
                if(testClass!=null)
                    method.invoke(object);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
