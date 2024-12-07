package com.klef.jfsd.exam;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class ClientDemo {
    public static void main(String[] args) {
        // Get Hibernate session
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            // Start a transaction
            transaction = session.beginTransaction();

            // Create and save Device
            Device device = new Device();
            device.setBrand("Generic");
            device.setModel("X100");
            device.setPrice(5000.0);
            session.save(device);

            // Create and save Smartphone
            Smartphone smartphone = new Smartphone();
            smartphone.setBrand("Apple");
            smartphone.setModel("iPhone 14");
            smartphone.setPrice(100000.0);
            smartphone.setOperatingSystem("iOS");
            smartphone.setCameraResolution("12 MP");
            session.save(smartphone);

            // Create and save Tablet
            Tablet tablet = new Tablet();
            tablet.setBrand("Samsung");
            tablet.setModel("Galaxy Tab S8");
            tablet.setPrice(60000.0);
            tablet.setScreenSize("11 inches");
            tablet.setBatteryLife("10 hours");
            session.save(tablet);

            // Commit the transaction
            transaction.commit();
            System.out.println("Records inserted successfully!");
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
            HibernateUtil.shutdown();
        }
    }
}
