package utils;

public class Hamming {

    public static int getHammingDistance(String simHash1,String simHash2){
        int distance = 0;
        if(simHash1.length() != simHash2.length()){
            //如果传入的hash长度不同，出错，返回-1
            distance = -1;
        }else{
            for(int i =0;i<simHash1.length();i++){
                //对每一位进行比较，算出hamming长度
                if(simHash1.charAt(i)!=simHash2.charAt(i)){
                    distance++;
                }
            }
        }
        return distance;
    }

    public static double getSimilarity(String simHash1,String simHash2){
        //通过simHash1和simHash2获得海明距离
        int distance = getHammingDistance(simHash1,simHash2);
        //通过海明距离算出相似度，并返回
        return  0.01 * (100 - (double)distance * 100 /128);
    }





}
