
/**
 * Write a description of ArrayGeneAsignment here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Arrays;
import edu.duke.*;
public class ArrayGeneAsignment {
    public String[] findGene(String dna)
    {
        dna = dna.toUpperCase();
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
    
    public void printAllGenes()
    {
        FileResource fr = new FileResource("brca1line.fa");
        String dna= fr.asString();
        System.out.println("genes length:"+dna.length());
        //String dna = "ATGTAAGATGCCCTAGT";
        String[] genes = findGene(dna);
        for (int i=0;i < genes.length;i++)
        {
            System.out.println(genes[i]);
        }
    }
    
    public double cgRatio(String dna)
    {
        double countC = 0.0;
        double countG = 0.0;
        int currIndex = 0;
        while(true)
        {
            currIndex = dna.indexOf("C",currIndex);
            if(currIndex == -1) 
                break;
            else
                countC =countC+1;
            currIndex++;
        }
        currIndex = 0;
        while(true)
        {
            currIndex = dna.indexOf("G",currIndex);
            if(currIndex == -1) 
                break;
            else
                countG= countG+1;
            currIndex++;
        }
        return countC/countG;
    }
    public void processGenes()
    {
        FileResource fr = new FileResource("brca1line.fa");
        String dna= fr.asString();
        System.out.println("dna:"+dna);
        int count9=0;
        String[] genes = findGene(dna);
        for (int i=0;i < genes.length;i++)
        {
            if(genes[i].length() >9)
            {    
                System.out.println(">9 characters: "+genes[i]);
                count9++;
            }
        }
        System.out.println("Number of genes >9 characters: "+count9);
        int countCG=0;
        for (int i=0;i < genes.length;i++)
        {
            if(cgRatio(genes[i])>0.35)
            {    
                System.out.println(">0.35 cg ratio: "+genes[i]);
                countCG++;
            }
        }
        System.out.println("Number of genes >0.35 cg ratio: "+countCG);
        String longest="";
        for (int i=0;i<genes.length;i++)
        {
            if(genes[i].length()> longest.length())
                longest = genes[i];
        }
        System.out.println("Longest gene:"+longest);
    }
}
