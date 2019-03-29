package com.stackroute;

public class Bartender {
    private boolean orderStatus;

    Bartender(){

        this.orderStatus=true;
    }

    public boolean prepareOrder(String dishName,String dishType){


        if(this.orderStatus){
            return true;
        }
        else{
            return false;
        }
    }
}
