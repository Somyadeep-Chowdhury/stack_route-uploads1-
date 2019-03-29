package com.stackroute;

import java.math.BigDecimal;

public class ToyBuilder {
    public static Car getCar(BigDecimal Price, String Color)
    {
        return new Car(Price,Color);
    }

    public static Train getTrain(BigDecimal Price, String Color)
    {
        return new Train(Price, Color);

    }

    public static Plane getPlane(BigDecimal Price, String Color)
    {
        return new Plane(Price, Color);
    }
}