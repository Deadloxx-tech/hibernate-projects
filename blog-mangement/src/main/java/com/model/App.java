package com.model;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        SessionFactory factory =
                new Configuration().configure().buildSessionFactory();

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        
        System.out.println("Enter User ID:");
        int uid = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter User Name:");
        String name = sc.nextLine();



        System.out.println("Enter Blog ID:");
        int blogid = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Blog Title:");
        String title = sc.nextLine();
        System.out.println("Enter Blog Content:");
        String content = sc.nextLine();

        
        System.out.println("Enter Comment ID:");
        int commentid = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Comment:");
        String commentText = sc.nextLine();




        User u = new User(uid, name);

        Blog b = new Blog(blogid, title, content);
        b.setUser(u);

        Comment c = new Comment(commentid, commentText);
        c.setUser(u);
        c.setBlog(b);


        session.save(u);
        session.save(b);
        session.save(c);

        tx.commit();
        session.close();

        System.out.println("Data inserted successfully!");

        sc.close();
    }
}