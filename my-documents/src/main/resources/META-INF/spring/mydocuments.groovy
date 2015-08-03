import com.apress.isf.spring.service.SearchEngineService
import com.apress.isf.spring.data.DocumentRepository
import com.apress.isf.java.model.Document
import com.apress.isf.java.model.Type

// Begins beans definition
beans {
    // engine bean
    // class: SearchEngineService
    // property: documentDAO, refers to documentDAO bean
    engine(SearchEngineService) { bean ->
        bean.scope = "prototype"
        documentDAO = ref("documentDAO")
    }

    // documentDAO bean definition
    // Class: DocumentRepository
    // Set the 4 properties with beans doc1, doc2, doc3, doc4
    documentDAO(DocumentRepository) { bean ->
        bean.scope = "prototype"
        document1 = ref("doc1")
        document2 = ref("doc2")
        document3 = ref("doc3")
        document4 = ref("doc4")
    }

    // doc beans definition, of class Document (model)
    // set three of its properties
    doc1(Document) {
        name = "Book Template"
        // type propertes refers to pdfType bean
        type = ref("pdfType")
        location = "/Users/felipeg/Documents/Random/Book Template.pdf"
    }
    doc2(Document) {
        name = "Sample Contract"
        type = ref("pdfType")
        location = "/Users/felipeg/Documents/Contracts/Sample Contract.pdf"
    }
    doc3(Document) {
        name = "Clustering with RabbitMQ"
        // type propertes refers to noteType bean
        type = ref("noteType")
        location = "/Users/felipeg/Documents/Random/Clustering with RabbitMQ.txt"
    }
    doc4(Document) {
        name = "Pro Spring Security Book"
        // type propertes refers to webType bean
        type = ref("webType")
        location = "http://www.apress.com/9781430248187"
    }
    // WebType bean definition
    webType(Type) {
        name = "WEB"
        desc = "Web Link"
        extension = ".url"
    }
    // pdfType bean definition
    pdfType(Type) {
        name = "PDF"
        desc = "Portable Document Format"
        extension = ".url"
    }
    // noteType bean definition
    noteType(Type) {
        name = "NOTE"
        desc = "Text Notes"
        extension = ".txt"
    }
}