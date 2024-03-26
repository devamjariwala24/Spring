package demo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* demo.ShoppingCart.checkout(..))")
    public void beforeLogger(JoinPoint jp){

        //here, it will give the signature of method which called this beforeLogger method
        System.out.println(jp.getSignature());
        System.out.println(jp.getArgs()[0].toString());
        System.out.println("Before Loggers");
    }

    @After("execution(* *.*.checkout(..))")
    public void afterLogger(){
        System.out.println("After Logger");
    }

    @Pointcut("execution(* demo.ShoppingCart.quantity(..))")
    public void afterReturningPointCut(){

    }

    @AfterReturning(pointcut = "afterReturningPointCut()",returning = "retValue")
    public void afterReturning(String retValue){
        System.out.println(STR."After Returning\{retValue}");
    }

}
