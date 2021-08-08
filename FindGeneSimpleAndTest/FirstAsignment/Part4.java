
/**
 * Write a description of Part4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.io.File;
import edu.duke.URLResource;
public class Part4 {
    public void checkURL()
    {
        URLResource ur = new URLResource("https://www.dukelearntoprogram.com//course2/data/manylinks.html");
        for(String line: ur.lines())
        {
            System.out.println(line);
        }
        int count = 0;
        for (String s:ur.words())
        {
            //not missing all case of link (uppercase and lowercase)
            String multi_cases = s.toLowerCase();
            //position of youtube link
            int index;
            //index = multi_cases.indexOf("youtube.com");
            index = s.indexOf("youtube.com");
            if (index == -1) continue;
            count = count + 1;
            int start_quote, end_quote;
            start_quote = s.lastIndexOf("\"",index);
            end_quote = s.indexOf("\"",index);
            System.out.println("Youtube link "+ count + " :"+ s.substring(start_quote, end_quote));
        }
        /*
        while (true)
        {
            int index = ur.as().indexOf("youtube.com");
        }*/
        
    }
}
