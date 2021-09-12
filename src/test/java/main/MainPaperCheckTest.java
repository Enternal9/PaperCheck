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

    @Test
    public void origAndOrigtestall(){
        String[] str = new String[6];
        str[0] = TxtIo.readTxt("D:\\works\\txttest\\orig.txt");
        str[1] = TxtIo.readTxt("D:\\works\\txttest\\orig_0.8_add.txt");
        str[2] = TxtIo.readTxt("D:\\works\\txttest\\orig_0.8_del.txt");
        str[3] = TxtIo.readTxt("D:\\works\\txttest\\orig_0.8_dis_1.txt");
        str[4] = TxtIo.readTxt("D:\\works\\txttest\\orig_0.8_dis_10.txt");
        str[5] = TxtIo.readTxt("D:\\works\\txttest\\orig_0.8_dis_15.txt");
        String ansfile = "D:\\works\\txttest\\ansall.txt";

        for(int i =1;i<6;i++){
            double ans =Hamming.getSimilarity(SimHash.getSimHash(str[0]),SimHash.getSimHash(str[i]));
            TxtIo.writeTxt(ans,ansfile,"原文","检测文"+i);
        }

    }

    @Test
    public void OrigAndOrigTest(){
        //原文和原文进行测试
        String str0 = TxtIo.readTxt("D:\\works\\txttest\\orig.txt");
        String str1 = TxtIo.readTxt("D:\\works\\txttest\\orig.txt");
        String ansfile = "D:\\works\\txttest\\OrigAndOrigTest.txt";
        double ans = Hamming.getSimilarity(SimHash.getSimHash(str0),SimHash.getSimHash(str1));
        TxtIo.writeTxt(ans,ansfile,"原文","原文");
    }

    @Test
    public void OrigAndAddTest(){
        String str0 = TxtIo.readTxt("D:\\works\\txttest\\orig.txt");
        String str1 = TxtIo.readTxt("D:\\works\\txttest\\orig_0.8_add.txt");
        String ansfile = "D:\\works\\txttest\\OrigAndAddTest.txt";
        double ans = Hamming.getSimilarity(SimHash.getSimHash(str0),SimHash.getSimHash(str1));
        TxtIo.writeTxt(ans,ansfile,"原文","add");
    }

    @Test
    public void OrigAndDelTest(){
        String str0 = TxtIo.readTxt("D:\\works\\txttest\\orig.txt");
        String str1 = TxtIo.readTxt("D:\\works\\txttest\\orig_0.8_del.txt");
        String ansfile = "D:\\works\\txttest\\OrigAndDelTest.txt";
        double ans = Hamming.getSimilarity(SimHash.getSimHash(str0),SimHash.getSimHash(str1));
        TxtIo.writeTxt(ans,ansfile,"原文","del");
    }

    @Test
    public void OrigAndDis1Test(){
        String str0 = TxtIo.readTxt("D:\\works\\txttest\\orig.txt");
        String str1 = TxtIo.readTxt("D:\\works\\txttest\\orig_0.8_dis_1.txt");
        String ansfile = "D:\\works\\txttest\\OrigAndDis1Test.txt";
        double ans = Hamming.getSimilarity(SimHash.getSimHash(str0),SimHash.getSimHash(str1));
        TxtIo.writeTxt(ans,ansfile,"原文","dis1");
    }

    @Test
    public void OrigAndDis2Test(){
        String str0 = TxtIo.readTxt("D:\\works\\txttest\\orig.txt");
        String str1 = TxtIo.readTxt("D:\\works\\txttest\\orig_0.8_dis_10.txt");
        String ansfile = "D:\\works\\txttest\\OrigAndDis2Test.txt";
        double ans = Hamming.getSimilarity(SimHash.getSimHash(str0),SimHash.getSimHash(str1));
        TxtIo.writeTxt(ans,ansfile,"原文","dis10");
    }

    @Test
    public void OrigAndDis3Test(){
        String str0 = TxtIo.readTxt("D:\\works\\txttest\\orig.txt");
        String str1 = TxtIo.readTxt("D:\\works\\txttest\\orig_0.8_dis_15.txt");
        String ansfile = "D:\\works\\txttest\\OrigAndDis3Test.txt";
        double ans = Hamming.getSimilarity(SimHash.getSimHash(str0),SimHash.getSimHash(str1));
        TxtIo.writeTxt(ans,ansfile,"原文","dis15");
    }

}