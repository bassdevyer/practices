package com.apress.isf.spring.config;

import com.apress.isf.java.model.Document;
import com.apress.isf.java.model.Type;
import com.apress.isf.java.service.SearchEngine;
import com.apress.isf.spring.data.DocumentDAO;
import com.apress.isf.spring.data.DocumentRepository;
import com.apress.isf.spring.service.SearchEngineService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by seymourdiera on 03/08/2015.
 */

/**
 * Indicates that a class declares one or more @Bean methods and may be processed by the Spring container to generate bean definitions and service requests for those beans at runtime
 */
@Configuration
public class MyDocumentsContext {

    // Every bean definition in your XML corresponds to the @Bean annotation placed into the method.

    // Map containing the documents
    private Map<String, Document> documents = new HashMap<String, Document>();
    // Map containing the types
    private Map<String, Type> types = new HashMap<String, Type>();

    /*
    Indicates that a method produces a bean to be managed by the Spring container.
     */
    @Bean
    // prodcues the bean webtype returns an instance of type from the map
    public Type webType() {
        return getTypeFromMap("web");
    }

    @Bean
    @Scope("prototype")
    // produces the bean engine, returns an instance of SearchEngineService, having set the documentDao property inside the method
    public SearchEngine engine() {
        SearchEngineService engine = new SearchEngineService();
        engine.setDocumentDAO(documentDAO());
        return engine;
    }

    // Constructor, initializes all the types and documents and populates the maps
    public MyDocumentsContext() {
        Type type = new Type();
        type.setName("PDF");
        type.setDesc("Portable Document Format");
        type.setExtension(".pdf");

        Document document = new Document();
        document.setName("Book Template");
        document.setType(type);
        document.setLocation("/Users/felipeg/Documents/Random/Book Template.pdf");

        documents.put("doc1", document);

        types.put("pdf", type);

        document = new Document();
        document.setName("Sample Contract");
        document.setType(type);
        document.setLocation("/Users/felipeg/Documents/Contracts/Sample Contract.pdf");

        documents.put("doc2", document);

        type = new Type();
        type.setName("NOTE");
        type.setDesc("Text Notes");
        type.setExtension(".txt");

        document = new Document();
        document.setName("Clustering with RabbitMQ");
        document.setType(type);
        document.setLocation("/Users/felipeg/Documents/Random/Clustering with RabbitMQ.txt");

        documents.put("doc3", document);

        types.put("note", type);

        type = new Type();
        type.setName("WEB");
        type.setDesc("Web Link");
        type.setExtension(".url");

        document = new Document();
        document.setName("Pro Spring Security Book");
        document.setType(type);
        document.setLocation("http://www.apress.com/9781430248187");

        documents.put("doc4", document);

        types.put("web", type);
    }

    // Instantiates the documentDao to be returned to populate the engine bean
    private DocumentDAO documentDAO() {
        DocumentRepository documentDAO = new DocumentRepository();
        documentDAO.setDocument1(getDocumentFromMap("doc1"));
        documentDAO.setDocument2(getDocumentFromMap("doc2"));
        documentDAO.setDocument3(getDocumentFromMap("doc3"));
        documentDAO.setDocument4(getDocumentFromMap("doc4"));
        return documentDAO;
    }

    // gets a document from the map given its key
    private Document getDocumentFromMap(String documentKey) {
        return documents.get(documentKey);
    }

    // gest a type from the map given its key
    private Type getTypeFromMap(String typeKey) {
        return types.get(typeKey);
    }


}
