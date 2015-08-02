package com.apress.isf.java;

import com.apress.isf.java.model.Document;
import com.apress.isf.java.model.Type;
import com.apress.isf.java.service.MySearchEngine;
import com.apress.isf.java.service.SearchEngine;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.print.Doc;
import java.util.List;

import static org.junit.Assert.*;


/**
 * Created by seymourdiera on 31/07/2015.
 */
public class MyDocumentsTest {

//    private SearchEngine engine = new MySearchEngine();
//
//    @Test
//    public void testFindByType() {
//        Type documentType = new Type();
//        documentType.setName("WEB");
//        documentType.setDesc("Web Link");
//        documentType.setExtension(".url");
//        List<Document> documents = engine.findByType(documentType);
//        /**
//         *  Asserts that an object isn't null. If it is an {@link AssertionError} is
//         * thrown.
//         */
//        assertNotNull(documents);
//        assertTrue(documents.size() == 1);
//        assertEquals(documentType.getName(),
//                documents.get(0).getType().getName());
//        assertEquals(documentType.getDesc(),
//                documents.get(0).getType().getDesc());
//        assertEquals(documentType.getExtension(),
//                documents.get(0).getType().getExtension());
//    }
//
//    @Test
//    public void testListAll() {
//        List<Document> documents = engine.findAll();
//        assertNotNull(documents);
//        assertTrue(documents.size() == 4);
//    }


    private ClassPathXmlApplicationContext context;
    private SearchEngine engine;
    private Type webType;

    @Before
    public void setUp(){
        context = new ClassPathXmlApplicationContext("META-INF/spring/mydocuments-context.xml");
        engine = context.getBean(SearchEngine.class);
        webType = context.getBean("webType", Type.class);
    }

    @Test
    public void testWithSpringFindByType(){
        List<Document> documents = engine.findByType(webType);
        assertNotNull(documents);
        assertTrue(documents.size() == 1);
        assertEquals(webType.getName(), documents.get(0).getType().getName());
        assertEquals(webType.getDesc(), documents.get(0).getType().getDesc());
        assertEquals(webType.getExtension(), documents.get(0).getType().getExtension());
    }

    @Test
    public void testWithSpringFindAll(){
        List<Document> documents = engine.findAll();
        assertNotNull(documents);
        assertTrue(documents.size() == 4);
    }



}
