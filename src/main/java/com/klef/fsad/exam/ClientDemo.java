package com.klef.fsad.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class ClientDemo
{
    public static void main(String[] args)
    {
        // Create SessionFactory
        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        // Open Session
        Session session = factory.openSession();

        Transaction tx = session.beginTransaction();

        // -------------------------------
        // I. INSERT RECORD
        // -------------------------------
        Hospital h = new Hospital(
                "Apollo Hospital",
                "Multi-speciality hospital",
                new Date(),
                "Active"
        );

        session.save(h);

        tx.commit();

        System.out.println("Inserted Successfully. ID: " + h.getId());

        // -------------------------------
        // II. FETCH RECORD BY ID
        // -------------------------------
        Session session2 = factory.openSession();

        Hospital fetched = session2.get(Hospital.class, h.getId());

        if(fetched != null)
        {
            System.out.println("\n--- Hospital Details ---");
            System.out.println("ID: " + fetched.getId());
            System.out.println("Name: " + fetched.getName());
            System.out.println("Description: " + fetched.getDescription());
            System.out.println("Date: " + fetched.getDate());
            System.out.println("Status: " + fetched.getStatus());
        }
        else
        {
            System.out.println("Record not found");
        }

        session2.close();
        factory.close();
    }
}