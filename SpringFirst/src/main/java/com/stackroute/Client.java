package com.stackroute;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.core.io.Resource;
//import org.springframework.beans.factory.BeanFactory;
//import org.springframework.beans.factory.xml.XmlBeanFactory;
//import org.springframework.core.io.ClassPathResource;

public class Client {

    public static void main(String[] args)
    {
        //Object Construction
//        Employee eRef = new Employee();
//        eRef.setEid(101);
//        eRef.setEname("Soumya");
//        eRef.setAddress("Kolkata");
//
//        System.out.println("Employee Details: "+eRef);

        //Spring Way || IOC(Inversion Of Control)
//

        ApplicationContext context= new ClassPathXmlApplicationContext("employeeBean.xml");
        Employee e1 = (Employee)context.getBean("emp1");
        System.out.println("Employee Details: "+e1);

    }

}
