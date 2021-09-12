package main;
import utils.Hamming;
import utils.SimHash;
import utils.TxtIo;
public class MainPaperCheck {
    public static void main(String[] args) {
        String str0 = TxtIo.readTxt(args[0]);
        String str1 = TxtIo.readTxt(args[1]);
        String resultFileName = args[2];

        String name1 = args[0].substring(args[0].lastIndexOf("\\")+1);
        String name2 = args[1].substring(args[1].lastIndexOf("\\")+1);

        String simHash0 = SimHash.getSimHash(str0);
        String simHash1 = SimHash.getSimHash(str1);

        double similarity = Hamming.getSimilarity(simHash0,simHash1);

        TxtIo.writeTxt(similarity,resultFileName,name1,name2);
        System.exit(0);
    }
}
