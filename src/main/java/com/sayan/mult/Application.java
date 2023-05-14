package com.sayan.mult;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sayan.mult.entities.Address;
import com.sayan.mult.entities.Student;

/**
 * Hello world!
 *
 */
public class Application 
{
	
	private static Log log = LogFactory.getLog(Application.class);
	
    public static void main( String[] args )
    {
    	log.debug("Hello World");
        System.out.println( "Hello World!" ); //NOSONAR
        
        ApplicationContext context = new ClassPathXmlApplicationContext("master-xml-config.xml");
        ApplicationContext context2 = new ClassPathXmlApplicationContext("master-xml-config2.xml");
        
        Student stud1 = context.getBean("Student", Student.class);
        Address add1 = context2.getBean("Address", Address.class);
        
        System.out.println(stud1);
        System.out.println(add1);        
        
    }
}
