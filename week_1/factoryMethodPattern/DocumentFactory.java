package week_1.factoryMethodPattern;
public abstract class DocumentFactory {
    // The Factory Method
    public abstract Document createDocument();
    
    // Optional: A method that uses the factory method
    public void processDocument() {
        Document doc = createDocument();
        doc.open();
        // perform other operations...
        doc.close();
    }
}