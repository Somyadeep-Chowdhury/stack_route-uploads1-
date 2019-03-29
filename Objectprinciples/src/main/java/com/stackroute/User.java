package com.stackroute;

import java.math.BigDecimal;

public class User {
    public static void main(String[] args) {
        Car myCar= ToyBuilder.getCar(new BigDecimal(200), "green");
        Toy myToy=myCar;
        myCar.isMovable();
        System.out.println(myToy.getColor());
        System.out.println(myToy.getPrice());
    }
}
