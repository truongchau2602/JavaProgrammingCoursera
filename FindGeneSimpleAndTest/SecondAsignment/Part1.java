
/**
 *  A.Find a gene in a strand of DNA where the stop codon could be any of
 the three stop codons “TAA”, “TAG”, or “TGA”.
 
 * B. Find all the genes (where the stop codon could be any of the three stop
 codons) in a strand of DNA.
 * 
 * @author Chau Truong 
 * @version (a version number or a date)
 */
import java.util.Arrays;
public class Part1 {
    public String[] findGene(String dna)
    {
        int startIndex = 0;
        String[] genes={};
        while (true)
        {
            startIndex = dna.indexOf("ATG",startIndex);
            if (startIndex == -1) break;
            int taaIndex = findStopCodon(dna, startIndex, "TAA");
            int tagIndex = findStopCodon(dna, startIndex, "TAG");
            int tgaIndex = findStopCodon(dna, startIndex, "TGA");
            int min = Math.min(taaIndex, tagIndex);
            min = Math.min(min,tgaIndex);
            if (min == dna.length())
                break;
            genes = Arrays.copyOf(genes, genes.length + 1);
            genes[genes.length - 1] = dna.substring(startIndex, min+3);
            startIndex = min + 3;
        }

        return genes;
    }
    
    public int findStopCodon(String str,int startIndex, String codon)
    {
        int currIndex = str.indexOf(codon, startIndex+3);
        while (true)
        {
            if (currIndex == -1) break;
            if((currIndex - startIndex) % 3 == 0)
            {
                return currIndex;
            }
            else currIndex = str.indexOf(codon,currIndex+1);
        }
        return str.length() ;
    }
    
    public void printAllGenes(String dna)
    {
        String[] genes = findGene(dna);
        for (int i=0;i < genes.length;i++)
        {
            System.out.println(genes[i]);
        }
    }    
    
    public void testFindStop(){
        //           01234567890123456789012345
        String dna ="xxxyyyzzzTAAxxxyyyzzzTAAxx";
        int dex = findStopCodon(dna,0,"TAA");
        if(dex != 9)  System.out.println("err on 9");
        dex = findStopCodon(dna,9,"TAA");
        if(dex != 21) System.out.println("err on 21");
        System.out.println("test finished!");
    }
    
    public void findAbc(String input) {
    int index = input.indexOf("abc");
    while (true) {
        if (index == -1|| index >= input.length() - 3) {
            break;
        }
        //System.out.println("index+1="+ Integer.toString(index+1));
        //System.out.println("index+4="+ Integer.toString(index+4));
        System.out.println("index before ="+ Integer.toString(index));
        String found = input.substring(index+1, index+4);
        System.out.println(found);
        index = input.indexOf("abc", index+3);
        System.out.println("index after ="+index);
    }
}
   
    public void test() {
    //no code yet
    Part1 test = new Part1();
    test.findAbc("abcabcabcabca");
}
    
    public void testFindGene()
    {
        Part1 test = new Part1();
        String dna = "ATGATCTAATTTATGCTFCAACGGTGAAGA";
        test.printAllGenes(dna);
        
        String dna2 = "ATGATCATAAGAAGATAATAGAGGGCCATGTAA";
        test.printAllGenes(dna2);
    }
    
}
