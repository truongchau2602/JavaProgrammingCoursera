
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
    public boolean twoOccurrences (String strA, String strB)
    {
        int position=0;
        int count = 0;
        while (true)
        {
            position = strB.indexOf(strA, position);
            if (position != -1)
            {
                count = count + 1;
            } else break;
            position = position + 1;
        }
        if (count > 1)
        return true;
        else return false;
    }
    public void test2Occurrences()
    {
        Part3 test = new Part3();
        String strA1 = "by";
        String strB1 = "A story by Abby Long";
        System.out.println("String A:"+strA1);
        System.out.println("String B:"+strB1);
        System.out.println("Occurrence: "+test.twoOccurrences(strA1, strB1));
        
        String strA2 = "atg";
        String strB2 = "ctgtatgta";
        System.out.println("String A:"+strA2);
        System.out.println("String B:"+strB2);
        System.out.println("Occurrence: "+test.twoOccurrences(strA2, strB2));
        
    }
    public String lastPart(String strA, String strB)
    {
        int position = strB.indexOf(strA);
        if (position != -1)
            return strB.substring(position+strA.length(), strB.length());
        else return strB;
    }
    public void testLastPart()
    {
        Part3 test = new Part3();
        String strA1 = "an";
        String strB1 = "banana";
        System.out.println("String A:"+strA1);
        System.out.println("String B:"+strB1);
        System.out.println("Last part:" + test.lastPart(strA1, strB1));
        
        String strA2 = "zoo";
        String strB2 = "forest";
        System.out.println("String A:"+strA2);
        System.out.println("String B:"+strB2);
        System.out.println("Last part: "+test.lastPart(strA2, strB2));
    }
}
