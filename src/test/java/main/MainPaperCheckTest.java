package main;

import org.junit.Test;
import utils.Hamming;
import utils.SimHash;
import utils.TxtIo;

import static org.junit.Assert.*;

public class MainPaperCheckTest {

    @Test
    public void origAndOrigTest() {
        String str0 = TxtIo.readTxt("D:\\works\\txttest\\orig.txt");
        String strtest = "D:\\works\\txttest\\orig.txt";
        String str1 = TxtIo.readTxt("D:\\works\\txttest\\orig_0.8_add.txt");
        String ansFileName = "D:\\works\\txttest\\anstest1.txt";
        String name1 = strtest.substring(strtest.lastIndexOf("\\")+1);
        double ans = Hamming.getSimilarity(SimHash.getSimHash(str0),SimHash.getSimHash(str1));
        System.out.println("原文：" + name1);
        TxtIo.writeTxt(ans,ansFileName,"orig.txt","orig_0.8_add.txt");
    }
}