package com.stackroute;

import java.math.BigDecimal;

public class Plane extends Toy implements Move,Fly {

    public Plane(BigDecimal Price, String Color){
        super(Price,Color);
    }
    @Override
    public void isFly() {
        System.out.println("Plane is flying");
    }

    @Override
    public void isMovable() {
        System.out.println("Plane is moving");
    }
}
