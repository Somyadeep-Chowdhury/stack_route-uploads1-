package com.stackroute;

import java.math.BigDecimal;

public class Train extends Toy implements Move {

    public Train(BigDecimal Price, String Color){
        super(Price,Color);
    }
    @Override
    public void isMovable() {
        System.out.println("Train is moving");
    }
}
