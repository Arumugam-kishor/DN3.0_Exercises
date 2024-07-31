package DN3.FactoryMethodPattern;

public class WordDocumentFactory extends DocumentFactory {
	@Override
    public Document createDocument() {
        return new WordDocument();
    }
}
