
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    public String findGenePart2(String dna, String start_codon, String stop_codon)
    {
        String gene = "";
        if(dna == dna.toUpperCase())
        {
            start_codon = start_codon.toUpperCase();
            stop_codon = stop_codon.toUpperCase();
        }
        
        if(dna == dna.toLowerCase())
        {
            start_codon = start_codon.toLowerCase();
            stop_codon = stop_codon.toLowerCase();
        }
        
        int startIndex = 0;
        int endIndex = 0;
        startIndex = dna.indexOf(start_codon, startIndex);
        if (startIndex == -1) return "";
        endIndex = dna.indexOf(stop_codon,startIndex + 3);
        if (endIndex == -1) return "";
        gene = dna.substring(startIndex, endIndex + 3);
        if (gene.length() % 3 == 0 )
            return gene;
        else return " not exist due to %3";
    
    }
    public void testSimpleGene()
    {
        Part2 creature = new Part2();
        String dna1 = "AGXATGAAGTAATT";
        System.out.println("DNA is:" + dna1);
        System.out.println("Gene is:" +creature.findGenePart2(dna1,"atg","taa"));
        
        String dna2 = "TGXATGAGAGT";
        System.out.println("DNA is:" + dna2);
        System.out.println("Gene is:" +creature.findGenePart2(dna2,"atg","taa"));
        
        String dna3 = "TXAAGTAA";
        System.out.println("DNA is:" + dna3);
        System.out.println("Gene is:" +creature.findGenePart2(dna3,"atg","taa"));
        
        String dna4 = "AATGGTAXATAAX";
        System.out.println("DNA is:" + dna4);
        System.out.println("Gene is:" +creature.findGenePart2(dna4,"atg","taa"));
    }
}
