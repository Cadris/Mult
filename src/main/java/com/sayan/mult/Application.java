package com.sayan.mult;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.sayan.mult.entities.Address;
import com.sayan.mult.entities.Student;

/**
 * Hello world!
 *
 */
public class Application 
{
	
	//private static Log log = LogFactory.getLog(Application.class);
	
    public static void main( String[] args ) throws Exception
    {
    	//log.debug("Hello World");
        System.out.println( "Hello World!" ); //NOSONAR
        
//        ApplicationContext context = new ClassPathXmlApplicationContext("master-xml-config.xml");
//        ApplicationContext context2 = new ClassPathXmlApplicationContext("master-xml-config2.xml");
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("entities-config.xml");
        
        
        Student stud1 = context.getBean("Student", Student.class);
        Address add1 = context.getBean("Address", Address.class);
        
        System.out.println("Ok");
        
        Student studentSayan = context.getBean("StudentFilled", Student.class);
        
        System.out.println(stud1);
        System.out.println(add1);        
        System.out.println(studentSayan);
        context.getBeanFactory().destroyBean("StudentFilled", studentSayan);
        Student studentSayan2 = context.getBean("StudentFilled", Student.class);
        System.out.println(studentSayan2);
        
        
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        
        // root elements
        Document doc = docBuilder.newDocument();
        Element rootElement = doc.createElement("company");
        doc.appendChild(rootElement);

//        doc.createElement("staff");
//        rootElement.appendChild(doc.createElement("staff"));
        Element sE = doc.createElement("stuff");
        sE.setTextContent("Sayan Dasgupta");
        sE.setAttribute("project", "NAMSI");
        rootElement.appendChild(sE);
        
        sE = doc.createElement("college");
        Element sE1 = doc.createElement("name");
        sE1.setTextContent("STCET");
        Element sE2 = doc.createElement("course");
        sE2.setTextContent("Electrical Engineering");
        sE.setTextContent("MAKAUT");
        sE.appendChild(sE1);
        sE.appendChild(sE2);
        rootElement.appendChild(sE);

        //...create XML elements, and others...

        // write dom document to a file
        try (FileOutputStream output =
                     new FileOutputStream("file.xml")) {
            writeXml(doc, output);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
        context.close();  // Closes all context
    }
    
    // write doc to output stream
    private static void writeXml(Document doc,
                                 OutputStream output)
            throws TransformerException {

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(output);

        transformer.transform(source, result);

    }
}
