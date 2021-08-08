
/**
 * Write a description of findGeneWhile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Arrays;
public class findGeneWhile {
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
    public void testFindStop(){
        //           01234567890123456789012345
        String dna ="xxxyyyzzzTAAxxxyyyzzzTAAxx";
        int dex = findStopCodon(dna,0,"TAA");
        if(dex != 9)  System.out.println("err on 9");
        dex = findStopCodon(dna,9,"TAA");
        if(dex != 21) System.out.println("err on 21");
        System.out.println("test finished!");
    }
    public void printAllGenes(String dna)
    {
        String[] genes = findGene(dna);
        for (int i=0;i < genes.length;i++)
        {
            System.out.println(genes[i]);
        }
    }
    public void testFindGene()
    {
        findGeneWhile test = new findGeneWhile();
        String dna = "ATGATCTAATTTATGCTFCAACGGTGAAGA";
        test.printAllGenes(dna);
        
        String dna2 = "ATGATCATAAGAAGATAATAGAGGGCCATGTAA";
        test.printAllGenes(dna2);
    }
}
