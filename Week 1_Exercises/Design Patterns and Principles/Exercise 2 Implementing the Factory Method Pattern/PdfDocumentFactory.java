package DN3.FactoryMethodPattern;

public class PdfDocumentFactory extends DocumentFactory {
	@Override
    public Document createDocument() {
        return new pdfDocument();
    }
}
