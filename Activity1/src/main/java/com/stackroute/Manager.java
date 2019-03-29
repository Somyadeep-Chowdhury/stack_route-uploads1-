package com.stackroute;

public class Manager {
    public boolean assignServer(String dishName,String dishType){
        return new Server().notifyOrder(dishName,dishType);

    }
}
