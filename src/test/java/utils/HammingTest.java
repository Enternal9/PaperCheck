package utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class HammingTest {

    @Test
    public void getHammingDistance() {
        String str0 = TxtIo.readTxt("D:\\works\\txttest\\orig.txt");
        String str1 = TxtIo.readTxt("D:\\works\\txttest\\orig_0.8_add.txt");
        int distance = Hamming.getHammingDistance(SimHash.getSimHash(str0),SimHash.getSimHash(str1));
        System.out.println("hamming distance:" + distance);
        System.out.println("相似度： " + (100-distance * 100/ 128) + "%");
    }

    @Test
    public void getHammingDistancefail() {
        //测试str0和str1长度不等的情况
        String str0 = "101010";
        String str1 = "1010101";
        int distance = Hamming.getHammingDistance(str0,str1);
        System.out.println("hamming distance:" + distance);
    }

    @Test
    public void getSimilarity() {
        String str0 = TxtIo.readTxt("D:\\works\\txttest\\orig.txt");
        String str1 = TxtIo.readTxt("D:\\works\\txttest\\orig_0.8_add.txt");
        int distance = Hamming.getHammingDistance(SimHash.getSimHash(str0),SimHash.getSimHash(str1));
        double similarity = Hamming.getSimilarity(SimHash.getSimHash(str0),SimHash.getSimHash(str1));
        System.out.println("hamming distance:" + distance);
        System.out.println("相似度: " + similarity);

    }
}