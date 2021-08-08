
/**
 * HowMany - Finding Multiple Occurrences.
 * This assignment will write a method to determine how many occurrences of 
a string appear in another string.
 
 * @author Chau Truong 
 * @version (a version number or a date)
 */
public class Part2 {
    public int countOccurrences(String stringa, String stringb)
    {
        int count=0;
        int position = 0;
        while(true)
        {
            position = stringb.indexOf(stringa, position);
            if(position == -1) break;
            count = count+1;
            position = position + 3;
        }
        return count;
    }
    public void testCount()
    {
        Part2 test = new Part2();
        System.out.println("Find codon:" + "GAA");
        System.out.println("In dna:" + "ATGAACGAATTGAATC");
        int result = test.countOccurrences("GAA", "ATGAACGAATTGAATC");
        System.out.println("Occurrence:"+Integer.toString(result));
    }
    }
    
