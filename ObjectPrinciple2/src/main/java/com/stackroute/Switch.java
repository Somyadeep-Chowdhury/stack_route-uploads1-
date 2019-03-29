package com.stackroute;

import java.util.Scanner;

public class Switch implements OnSwitch,OffSwitch {
    public void turnOn()
    {
        System.out.println("...Bulb is on...");
    }

    public void turnOff()
    {
        System.out.println("...Bulb is off...");
    }

    public static void main(String[] args)
    {
        int sw=0;
        System.out.println("\n1: Press 1 to switch on the bulb\n2: Press 2 to switch off the buld\n3: Press 3 to exit from the system\n: Enter your choice:");
        Scanner sc=new Scanner(System.in);
        sw=sc.nextInt();
        switch (sw)
        {
            case 1:new Switch().turnOn();
                break;
            case 2:new Switch().turnOff();
                break;
            default:
                System.out.println("Wrong Switch,try again");
                break;
            case 3:System.exit(0);
                break;

        }
    }
}
