package com.sayan.mult;

import java.lang.reflect.InaccessibleObjectException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

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
        
        try {
        	throw new InaccessibleObjectException("This is the exception message");
        } catch (Exception e) {
			log.error("An Error Occured: ", e);
		}
        
        System.out.println("Data OUT"); //NOSONAR
    }
}
