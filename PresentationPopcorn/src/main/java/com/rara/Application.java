package com.rara;

import com.rara.model.FoodItem;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by sparkle on 8/28/15.
 */

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
        FoodItem f = new FoodItem();
    }
}
