package mtt.ls.io;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.*;
import java.util.Arrays;

/**
 * 版权所有 (C) 2019-2029 长沙新时科技发展有限公司。保留所有权利。
 * 版本：
 * 修改记录：
 * 1、2019年05月07天，劉松创建。
 * 纯文本字符流
 */
public class Demo05
{
    public static void main(String[] args)
    {
        textStreamTest();
    }
    public static void textStreamTest(){
        File file=new File("1.txt");
        Reader is=null;
        try
        {
            is=new FileReader(file);
            char[] car = new char[20];
            int len=0;
            while (-1!=(len=is.read(car))){
                System.out.println(Arrays.toString(car));
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }finally
        {
            if(is!=null){
                try
                {
                    is.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
}
