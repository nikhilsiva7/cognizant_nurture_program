import week_1.factoryMethodPattern.Document;
import week_1.factoryMethodPattern.DocumentFactory;
import week_1.factoryMethodPattern.ExcelDocumentFactory;
import week_1.factoryMethodPattern.PdfDocumentFactory;
import week_1.factoryMethodPattern.WordDocumentFactory;

public class FactoryMethodPatternExample {
    public static void main(String[] args) {
        // Create a Word document using its factory
        DocumentFactory wordFactory = new WordDocumentFactory();
        Document wordDoc = wordFactory.createDocument();
        wordDoc.open();
        
        // Create a PDF document using its factory
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        Document pdfDoc = pdfFactory.createDocument();
        pdfDoc.open();
        
        // Create an Excel document using its factory
        DocumentFactory excelFactory = new ExcelDocumentFactory();
        Document excelDoc = excelFactory.createDocument();
        excelDoc.open();
    }
}