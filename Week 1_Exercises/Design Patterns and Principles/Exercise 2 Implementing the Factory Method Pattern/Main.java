package DN3.FactoryMethodPattern;
import java.util.Scanner;

public class Main extends Thread {
	public static void main(String[] args) throws InterruptedException {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter The Document Type(pdf,word,excel)");
		String s = scan.nextLine();
		switch(s) {
		case "pdf":
			DocumentFactory pdfFactory = new PdfDocumentFactory();
	        Document pdfDoc = pdfFactory.createDocument();
	        pdfDoc.open();
	        Thread.sleep(2000);
	        pdfDoc.close();
	        break;
		case "word":
			DocumentFactory wordFactory = new WordDocumentFactory();
			Document wordDoc = wordFactory.createDocument();
	        wordDoc.open();
	        Thread.sleep(2000);
	        wordDoc.close();
	        break;
		case "excel":
			DocumentFactory excelFactory = new ExcelDocumentFactory();
	        Document excelDoc = excelFactory.createDocument();
	        excelDoc.open();
	        Thread.sleep(2000);
	        excelDoc.close();
	        break;
	     default:
	    	 System.out.println("Invalid Document Type Entered");
	    	 break;
		}
    }
}
