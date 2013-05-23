
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class jsoupTester {
	/*
	 * Example to test jsoup
	 */
	
	public static void main(String[] args){
		Document doc;
		
		try{
			doc = Jsoup.connect("http://docs.oracle.com/javase/tutorial/java/javaOO/variables.html").get();
			
			String title = doc.title();
			System.out.print("Title: " + title);
			
			Elements links = doc.select(".linkAHEAD a,.linkBHEAD a");
			for(Element link : links ){
				
				// Print all links with name and target from href attr
				System.out.print("\nLink Name : " + link.text());
				System.out.print("\nLink Address : " + link.attr("href") + "\n\n");
				
			}
		}
		catch (IOException exp){
			exp.printStackTrace();
		}
		
		
	}
}