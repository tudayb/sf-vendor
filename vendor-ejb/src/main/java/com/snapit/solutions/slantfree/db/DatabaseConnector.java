/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.snapit.solutions.slantfree.db;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

/**
 *
 * @author sudheerparasker
 */
public class DatabaseConnector {

    private static final String DB_CONNECTION_URI = "mongodb://slantfreeAdmin:10152009@localhost:27017/slantfree-vendor-db";
    private static final String DB_NAME = "slantfree-vendor-db";

    /**
     * Simple Database Connector - Connects to MongoDB
     * @return 
     */
    public static MongoDatabase getDbConnection() {
        try {

            MongoClient mongoClient = getMongoClient();

            // Now connect to your databases
            MongoDatabase db;
            db = mongoClient.getDatabase(DB_NAME);
            System.out.println("Connect to database successfully");

            MongoCollection coll = db.getCollection("vendor");
            System.out.println("Collection mycol selected successfully");

            FindIterable iterable = coll.find();
            MongoCursor cursor = iterable.iterator();
            int i = 1;

            while (cursor.hasNext()) {
                System.out.println("Inserted Document: " + i);
                System.out.println(cursor.next());
                i++;
            }

            System.out.println("Document deleted successfully");
            return db;
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return null;
    }

    private static MongoClient getMongoClient() {
        // To connect to mongodb server
        MongoClientURI connectionString = new MongoClientURI(DB_CONNECTION_URI);
        MongoClient mongoClient = new MongoClient(connectionString);
        return mongoClient;
    }

    /**
     * Morphia Connector for MongoDB
     * @return 
     */
    public static Datastore getDataStore() {
        final Morphia morphia = new Morphia();

        // tell Morphia where to find your classes
       // can be called multiple times with different packages or classes
        morphia.mapPackage("com.snapit.solutions.slantfree.entity");

        // create the Datastore connecting to the default port on the local host
        final Datastore datastore = morphia.createDatastore(getMongoClient(), DB_NAME);
        datastore.ensureIndexes(); //creates all defined with @Indexed
        datastore.ensureCaps(); //creates all collections for @Entity(cap=@CappedAt(...))
        return datastore;
    }
}
