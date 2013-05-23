
import java.awt.Image;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class jsoupImage {
	/*
	 * Example to test jsoup
	 */
	public static void main(String[] args){
		
		int numberOfComics = 1215;
		
		for(int i=1032; i<=numberOfComics; i++){
			
			//get all comics till date. 
			getComic("http://xkcd.com/" + i);
		}
	}
	
	
	public static void getComic(String arg){
		Document doc;
		
		try{
			doc = Jsoup.connect(arg).get();
			
			//String title = doc.title();
			//System.out.print("Title: " + title);
			
			// Select the img tag in the comic id
			Elements links = doc.select("#comic img");
			System.out.print("\nComic Name : " + links.attr("alt"));
			System.out.print("\nImage Source : " + links.attr("src") + "\n\n");
			URL url = new URL(links.attr("src"));
			
			RenderedImage comic = ImageIO.read(url);
			String baseName = links.attr("alt").replaceAll("\\s","_");
			
			ImageIO.write(comic,"png",new File("/home/paranoidsp/Pictures/xkcd/" + baseName + ".png"));
			
		
			/*
			 * Unfortunately, the transcript isn't formatted, so I get one 
			 * large line of text instead of readable dialogue.
			 * TODO: Fix this. Find a way to get it.
			 * 
			Elements transcript = doc.select("#transcript");
			System.out.print("Transcript: \n" + transcript.text());
			*/
			
		}
		catch (IOException exp){
			exp.printStackTrace();
		}
		
		
	}
}