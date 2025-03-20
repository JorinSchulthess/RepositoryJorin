package org.example;
import java.util.stream.StreamSupport;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;



public class Main {
    public static void main(String[] args) {

        String uri = "mongodb://localhost:27017";
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("tutorial");
            MongoCollection<Document> collection = database.getCollection("products");
            System.out.println("\nString\n");
            StreamSupport.stream(collection.find().spliterator(), false)
                    .map(Document::toString)
                    .forEach(System.out::println);
            System.out.println("\nJson\n");StreamSupport.stream(collection.find().spliterator(), false)
                    .map(Document::toJson)
                    .forEach(System.out::println);
        }
    }
}