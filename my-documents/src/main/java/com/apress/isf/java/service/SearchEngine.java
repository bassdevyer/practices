package com.apress.isf.java.service;

import com.apress.isf.java.model.Document;
import com.apress.isf.java.model.Type;

import java.util.List;

/**
 * This class will use the Document class and the Type relationship
 * Created by seymourdiera on 31/07/2015.
 */
public interface SearchEngine {
    public List<Document> findByType(Type documentType);
    public List<Document> findAll();

}
