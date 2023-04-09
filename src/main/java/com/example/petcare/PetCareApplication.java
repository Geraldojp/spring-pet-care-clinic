package com.example.petcare;


import com.example.petcare.config.BeanConfiguration;
import com.example.petcare.controller.MenuController;
import com.example.petcare.controller.OwnerController;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PetCareApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfiguration.class);
        MenuController menuController = ctx.getBean(MenuController.class);
        menuController.mainMenu();
    }

}
