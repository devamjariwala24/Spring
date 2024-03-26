package demo;

import org.springframework.stereotype.Component;

@Component
public class ShoppingCart {

    public void checkout(String status){
        System.out.println(STR."\{status} Method called from ShoppingCart class");
    }

    public int quantity(){
        return 200;
    }
}
