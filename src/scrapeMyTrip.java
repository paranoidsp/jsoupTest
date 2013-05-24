import java.io.IOException;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class scrapeMyTrip {
	/*
	 * Example to test jsoup
	 */
	
	public static void main(String[] args){
		Document doc;
		
		try{
			doc = Jsoup.connect("http://hotel.makemytrip.com/makemytrip/site/hotels/search").data("cityName","Hyderabad").data("checkInDate","05/15/2013").data("checkOutDate","05/177/2013").userAgent("Mozilla").post();
			String title = doc.title();
			System.out.print("Title: " + title);
			//System.out.print(doc);
			
			Elements links = doc.select(".hotelNameLk");
			for(Element link : links ){
				
				// Print all links with name and target from href attr
				System.out.print("\nHotel Name : " + link.text());
//				System.out.print("\nLink Address : " + link.attr("href") + "\n\n");
				
			}
		}
		catch (IOException exp){
			exp.printStackTrace();
		}
		
		
	}
}