
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Arrays;
public class Part3 {
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
        System.out.println("Number of genes:"+genes.length);
    }
    public void testCountGenes()
    {
        Part3 test = new Part3();
        String dna = "ATGTAAGATGCCCTAGT";
        System.out.println("DNA Sequence:"+dna);
        test.printAllGenes(dna);
        
        String dna2 = "AATGCTAACTAGCTGACTAAT";
        System.out.println("DNA Sequence:"+dna2);
        test.printAllGenes(dna2);
    }

}
