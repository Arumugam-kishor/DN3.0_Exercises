package DN3.FactoryMethodPattern;

public class ExcelDocumentFactory extends DocumentFactory {
	 @Override
	    public Document createDocument() {
	        return new ExcelDocument();
	    }
}
