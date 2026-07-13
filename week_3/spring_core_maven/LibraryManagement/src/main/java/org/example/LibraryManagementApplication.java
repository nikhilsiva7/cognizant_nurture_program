package org.example;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.example.service.BookService;


public class LibraryManagementApplication {

    public static void Main(String[] Args){

        System.out.println("---Starting Library Management System---");

        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");

        BookService service = (BookService) context.getBean("bookService");

        service.processBookRequest();

        System.out.println("--- Application Finished ---");

    }

}
