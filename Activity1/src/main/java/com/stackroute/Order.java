package com.stackroute;

public class Order {

    private String dishName;
    private String dishType;
    private int custAge;
    private boolean orderStatus;



    //Server server=new Server();
    //Manager manager=new Manager();

    Order(String dishN,String dishT,int custA){
        this.dishName=dishN;
        this.dishType=dishT;
        this.custAge=custA;
        this.verifyOrder(dishName,dishType,custAge);
    }


    private void verifyOrder(String dishName,String dishType,int custAge){

        if(dishType.equals("food")){
            this.orderStatus=new Manager().assignServer(dishName,dishType);
            if(orderStatus){
                System.out.println("Served");
            }
            else{
                System.out.println("not served");
            }

        }
        else if(dishType.equals("drink")){
            if(custAge<21){
                System.out.print("Sorry!!!...You are only eligible to order food");
            }
            else {
                this.orderStatus=new Manager().assignServer(dishName, dishType);
                if(this.orderStatus)
                    System.out.println("served");
                else
                    System.out.println("not served");

            }
        }

    }



}
