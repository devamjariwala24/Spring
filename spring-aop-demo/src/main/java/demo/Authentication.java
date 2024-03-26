package demo;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Authentication {

    @Pointcut("within(demo..*)")
    public void authenticatingPointCut(){

    }

    @Pointcut("within(demo..*)")
    public void authorizationPointCut(){

    }

    @Before("authenticatingPointCut() && authorizationPointCut()")
    // you can also use this here: @Before("authenticatingPointCut() || authorizationPointCut()")
    public void authenticate(){
        System.out.println("Authenticating the request");
    }
}
