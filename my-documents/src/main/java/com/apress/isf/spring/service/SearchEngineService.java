package com.apress.isf.spring.service;

import com.apress.isf.java.model.Document;
import com.apress.isf.java.model.Type;
import com.apress.isf.java.service.SearchEngine;
import com.apress.isf.spring.data.DocumentDAO;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by seymourdiera on 02/08/2015.
 */
public class SearchEngineService implements SearchEngine{

    private DocumentDAO documentDAO;

    public DocumentDAO getDocumentDAO() {
        return documentDAO;
    }

    public void setDocumentDAO(DocumentDAO documentDAO) {
        this.documentDAO = documentDAO;
    }

    @Override
    public List<Document> findByType(Type documentType) {
        List<Document> result = new ArrayList<Document>();
        for(Document document : findAll()){
            if(document.getType().getName().equals(documentType.getName())){
                result.add(document);
            }
        }
        return result;
    }

    @Override
    public List<Document> findAll() {
        return Arrays.asList(documentDAO.getAll());
    }
}
