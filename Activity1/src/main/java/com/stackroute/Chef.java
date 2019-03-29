package com.stackroute;

public class Chef {
    private boolean orderStatus;

    Chef(){
        this.orderStatus=true;
    }

    public boolean prepareOrder(String dishName,String dishType){

        if(this.orderStatus){
            return  true;

        }
        else{
            return false;
        }
    }
}
