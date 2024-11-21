package org.example.mongocrud;

import com.mongodb.client.*;
import org.bson.Document;
import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

public class MongoDbUtil {

    private static final String CONNECTION_STRING = "mongodb://localhost:27017"; // Replace with your MongoDB URI
    private static final String DATABASE_NAME = "myDatabase"; // Replace with your database name
    private static final String COLLECTION_NAME = "people"; // Replace with your collection name

    private static MongoClient mongoClient;
    private static MongoDatabase database;
    private static MongoCollection<Document> collection;

    static {
        // Initialize MongoDB connection
        mongoClient = MongoClients.create(CONNECTION_STRING);
        database = mongoClient.getDatabase(DATABASE_NAME);
        collection = database.getCollection(COLLECTION_NAME);
    }

    public static void createPerson(String id, String name, String age, String city) {
        Document person = new Document("id", id)
                .append("name", name)
                .append("age", age)
                .append("city", city);
        collection.insertOne(person);
    }

    public static Document readPerson(String id) {
        return collection.find(new Document("id", id)).first();
    }

    public static void updatePerson(String id, String name, String age, String city) {
        Document updatedPerson = new Document("name", name)
                .append("age", age)
                .append("city", city);
        collection.updateOne(new Document("id", id), new Document("$set", updatedPerson));
    }

    public static void deletePerson(String id) {
        collection.deleteOne(new Document("id", id));
    }
}
