package com.stackroute;

import java.math.BigDecimal;

public class Car extends Toy implements Move {
    public Car(BigDecimal Price, String Color){
        super(Price,Color);
    }
    @Override
    public void isMovable() {
        System.out.println("Car is moving");
    }
}
