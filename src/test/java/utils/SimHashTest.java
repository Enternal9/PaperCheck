package utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class SimHashTest {

    @Test
    public void getHash() {
        String[] strings = {"超新星啊","更加闪耀吧","在星降之夜","称赞红月"};
        for(String string:strings){
            String stringHash = SimHash.getHash(string);
            System.out.println(stringHash.length());
            System.out.println(stringHash);
        }
    }

    @Test
    public void getSimHash() {
        String str0 = TxtIo.readTxt("D:\\works\\txttest\\orig.txt");
        String str1 = TxtIo.readTxt("D:\\works\\txttest\\orig_0.8_add.txt");
        System.out.println(SimHash.getSimHash(str0));
        System.out.println(SimHash.getSimHash(str1));
    }
}