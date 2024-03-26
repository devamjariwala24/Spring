package demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args){

        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        Staff s1 = context.getBean(Doctor.class);
        s1.assist();
//        System.out.println(s1.getQualification());

        Staff s2 = context.getBean(Nurse.class);
        s2.assist();
    }
}
