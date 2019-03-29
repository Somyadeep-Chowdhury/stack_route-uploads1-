package com.stackroute;


//Bean or Model or POJO(Plain Old Java Object)
public class Employee {
    //Attribute

    int eid;
    String ename;
    Address address;

    //Methods
    public Employee()
    {
        System.out.println("Object Created");
    }

    //Constructor injection
    public Employee(Address address){
        this.address=address;
    }

    public Employee(int eid, String ename, Address address) {
        this.eid = eid;
        this.ename = ename;
        this.address = address;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public Address getAddress() {
        return address;
    }

    //Setter Injection
    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "eid=" + eid +
                ", ename='" + ename + '\'' +
                ", address=" + address +
                '}';
    }
}
