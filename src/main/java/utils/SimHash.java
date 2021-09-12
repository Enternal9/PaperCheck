package utils;

import com.hankcs.hanlp.HanLP;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.List;

public class SimHash {

    public static String getHash(String str){
        try{
            //利用MD5获得hash值
            MessageDigest md = MessageDigest.getInstance("MD5");
            return new BigInteger(1,md.digest(str.getBytes("UTF-8"))).toString(2);
        }catch(Exception e){
            e.printStackTrace();
        }
        return str;
    }

    public static String getSimHash(String str){
        try{
            //文本长度太短，HanLp无法获得关键字
            if(str.length()<200) throw new ShortStringException("文本过短");
        }catch (ShortStringException e){
            e.printStackTrace();
            return null;
        }

        //用数组表示特征向量，取128位，从0 1 2位开始表示从高位到低位
        int [] v = new int[128];
        //利用hankcs包接口进行分词
        List<String> keywordList = HanLP.extractKeyword(str,str.length());
        //hash
        int size = keywordList.size();
        int i = 0;
        for(String keyword : keywordList){
            //获取hash值
            String keywordHash = getHash(keyword);
            if(keywordHash.length()<128){
                //若hash值低于128位，则补0，补全128位
                int dif = 128 - keywordHash.length();
                for(int j=0;j<dif;j++){
                    keywordHash += "0";
                }
            }

            //加权
            for(int j=0;j<v.length;j++){
                //对keywordHash每一位和'1'比较
                if(keywordHash.charAt(j)=='1'){
                    v[j] += (10 - (i / (size / 10)));
                }
                else{
                    v[j] -= (10 - (i / (size/10)));
                }
            }
            i++;
        }
        String simHash = "";
        for(int j=0;j<v.length;j++){
            //从高位遍历到低位
            if(v[j]<=0){
                simHash += "0";
            }else{
                simHash += "1";
            }
        }
        return simHash;
    }
}
