package com.apress.isf.java.service;

import com.apress.isf.java.model.Document;
import com.apress.isf.java.model.Type;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by seymourdiera on 31/07/2015.
 */
public class MySearchEngine implements SearchEngine {
    @Override
    public List<Document> findByType(Type documentType) {
        List<Document> result = new ArrayList<Document>();
        for(Document document : storage()){
            if(document.getType().getName().equals(documentType.getName())){
                result.add(document);
            }
        }
        return result;
    }

    @Override
    public List<Document> findAll() {
        return storage();
    }

    private List<Document> storage(){
        List<Document> result = new ArrayList<Document>();
        Type type = new Type();
        type.setName("PDF");
        type.setDesc("Portable Document Format");
        type.setExtension(".pdf");
        Document document = new Document();
        document.setName("Book Template");
        document.setType(type);
        document.setLocation("/Documents/Book Template.pdf");
        result.add(document);
        result.add(document);
        result.add(document);

        Type documentType = new Type();
        documentType.setName("WEB");
        documentType.setDesc("Web Link");
        documentType.setExtension(".url");
        Document document1 = new Document();
        document1.setName("Book Template");
        document1.setType(documentType);
        document1.setLocation("/Documents/Book Template.pdf");
        result.add(document1);
//        result.add(document);
//        result.add(document);
//        result.add(document);
        return result;
    }
}
