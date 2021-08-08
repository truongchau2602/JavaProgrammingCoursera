
/**
 * Write a description of FindGeneSimple here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {
    public String[] findGene(String dna)
    {
        int startIndex = 0;
        int endIndex = 0;
        String[] genes ={"","",""};
        int j = 0;
        while (true)
        {
            startIndex = dna.indexOf("ATG", startIndex);
            if (startIndex == -1) break;
            endIndex = dna.indexOf("TAA", startIndex+3);
            if (endIndex == -1) break;
            genes[j] = dna.substring(startIndex,endIndex+3);
            j = j+1;
        }
        
        return genes;
    }
    public String findGenePart1(String dna)
    {
        String gene = "";
        int startIndex = 0;
        int endIndex = 0;
        startIndex = dna.indexOf("ATG", startIndex);
        if (startIndex == -1) return "";
        endIndex = dna.indexOf("TAA",startIndex + 3);
        if (endIndex == -1) return "";
        gene = dna.substring(startIndex, endIndex + 3);
        if (gene.length() % 3 == 0 )
            return gene;
        else return " not exist due to %3";
    
    }
    public void testSimpleGene()
    {
        Part1 creature = new Part1();
        String dna1 = "AAATGCCCTAACTAGATTAAGAAACC";
        System.out.println("DNA is:" + dna1);
        System.out.println("Gene is:" +creature.findGenePart1(dna1));
        
        String dna2 = "TGXATGAGAGT";
        System.out.println("DNA is:" + dna2);
        System.out.println("Gene is:" +creature.findGenePart1(dna2));
        
        String dna3 = "TXAAGTAA";
        System.out.println("DNA is:" + dna3);
        System.out.println("Gene is:" +creature.findGenePart1(dna3));
        
        String dna4 = "AATGGTAXATAAX";
        System.out.println("DNA is:" + dna4);
        System.out.println("Gene is:" +creature.findGenePart1(dna4));
    }
    
}

