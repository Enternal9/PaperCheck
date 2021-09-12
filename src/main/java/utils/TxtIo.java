package utils;

import java.io.*;

public class TxtIo {
    public static String readTxt(String txtPath){
    String str = "";
    String strLine;
    //将txt按行读入str中
        File file = new File(txtPath);
        FileInputStream fis = null;
        try{
            fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis,"UTF-8");
            BufferedReader br = new BufferedReader(isr);

            //字符串拼接
            while((strLine = br.readLine())!= null){
                str += strLine;
            }

            //关闭资源
            isr.close();
            br.close();
            fis.close();

        }catch(IOException e){
            e.printStackTrace();
        }
        return str;
    }

    public static void writeTxt(double txtElem,String txtPath,String name1,String name2){
        txtElem = txtElem * 100;
        String str = Double.toString(txtElem);
        File file = new File(txtPath);
        FileWriter fw = null;
        try{
            fw = new FileWriter(file,true);//写入文件的时候不覆盖内容，在后面进行附加
            fw.write("原文：" + name1 + "\n");
            fw.write("检测文：" + name2 + "\n");
            fw.write("查重率为：");
            fw.write(str, 0, (str.length()>3?5:str.length()));//输出的结果为百分数，含2位小数
            fw.write("%");
            fw.write("\r\n");
            System.out.println("查重结果已输出到：" + txtPath);
            fw.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
