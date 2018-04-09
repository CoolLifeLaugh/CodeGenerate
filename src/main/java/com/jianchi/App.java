package com.jianchi;

import com.jianchi.html.Generate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("core.xml");
//        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.jianchi");
        Generate generate = (Generate)applicationContext.getBean("generate");

            generate.toGenerateHTml();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
