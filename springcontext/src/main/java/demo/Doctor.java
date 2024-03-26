package demo;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Doctor implements Staff, BeanNameAware {

//    private String qualification;

    public void assist(){
        System.out.println("Doctor is assisting");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("Set Bean Name method is called");
    }


    @PostConstruct
    public void postConstruct(){
        System.out.println("Post Construct method is called now. Notice the change");
    }

//    public String getQualification() {
//        return qualification;
//    }
//
//    public void setQualification(String qualification) {
//        this.qualification = qualification;
//    }
}
