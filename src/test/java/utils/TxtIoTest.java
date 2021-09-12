package utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class TxtIoTest {

    @Test
    public void readTxt() {
        //路径存在，正常读取
        String str = TxtIo.readTxt("D:\\works\\txttest\\orig.txt");
        String[] Strings = str.split(" ");
        for(String string : Strings){
            System.out.println(string);
        }
    }

    @Test
    public void writeTxt() {
        //路径存在，正常写入
        double[] elem = {0.1111,0.2222,0.3333,0.4444,0.5555};
        for(int i = 0;i<elem.length;i++){
            TxtIo.writeTxt(elem[i],"D:\\works\\txttest\\test.txt","name1","name2");
        }
    }

    @Test
    public void readTxtfail(){
        //路径不存在，读取失败
        String str = TxtIo.readTxt("D:\\works\\txttest\\abc.txt");
    }

    @Test
    public void writeTxtfail(){
        double[] elem = {0.11,0.22,0.33,0.44,0.55};
        for(int i=0;i<elem.length;i++){
         TxtIo.writeTxt(elem[i],"D:\\works\\txtest\\ans.txt","name1","name2");
        }
    }
}