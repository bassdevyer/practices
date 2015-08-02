package com.apress.isf.spring.data;

import com.apress.isf.java.model.Document;

/**
 * Is the class that holds all the information about the documents.
 * Created by seymourdiera on 02/08/2015.
 */
public interface DocumentDAO {
    public Document[] getAll();
}
