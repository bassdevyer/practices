package com.apress.isf.spring.annotated.service;

import com.apress.isf.java.model.Document;
import com.apress.isf.java.model.Type;
import com.apress.isf.java.service.SearchEngine;
import com.apress.isf.spring.data.DocumentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by seymourdiera on 03/08/2015.
 */
// Spring will recognize it as a managed component
// This is a specialization of the @Component annotation and it fulfills the idea of a service layer
@Service("engine")
@Scope("prototype")
public class AnnotatedSearchEngine implements SearchEngine {

    // This annotation will tell the Spring container to actually create the instance and assign it to the declared variable.
    @Autowired
    private DocumentDAO documentDAO;

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
