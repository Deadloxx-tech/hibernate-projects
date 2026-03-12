package com.example;
import java.util.Date;
import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class App {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter Student Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Student Age: ");
            int age = sc.nextInt();

            sc.nextLine(); // clear buffer

            System.out.print("Enter Book Title: ");
            String title = sc.nextLine();

            System.out.print("Enter Book Author: ");
            String author = sc.nextLine();

            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();

            Student student = new Student(name, age);
            Book book = new Book(title, author);

            session.save(student);
            session.save(book);

            Issue issue = new Issue(student.getId(), book.getId(), new Date());
            session.save(issue);

            tx.commit();
            session.close();
        } catch (HibernateException e) {
            
            e.printStackTrace();
        }

        System.out.println("Data saved successfully!");
    }
}