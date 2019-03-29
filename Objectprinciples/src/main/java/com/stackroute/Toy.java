package com.stackroute;

import java.math.BigDecimal;

public class Toy {

    BigDecimal Price;
    String Color;

    public BigDecimal getPrice() {
        return Price;
    }

    public String getColor() {
        return Color;
    }

    Toy(BigDecimal Price, String Color)
    {
        this.Color=Color;
        this.Price=Price;
    }

}
