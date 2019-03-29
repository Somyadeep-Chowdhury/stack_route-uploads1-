package com.stackroute;

public class Server {
    private boolean orderStatus;

    public boolean notifyOrder(String dishName,String dishType){

        if(dishType.equals("food")){

            this.orderStatus=new Chef().prepareOrder(dishName,dishType);
            return this.orderStatus;
        }
        else if(dishType.equals("drink")){
            this.orderStatus=new Bartender().prepareOrder(dishName,dishType);
            return this.orderStatus;
        }
        else{
            return false;
        }

    }
}
