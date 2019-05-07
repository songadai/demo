package mtt.ls.io;

import java.io.*;
import java.util.Arrays;

/**
 * 版权所有 (C) 2019-2029 长沙新时科技发展有限公司。保留所有权利。
 * 版本：
 * 修改记录：
 * 1、2019年05月07天，劉松创建。
 * 缓冲流
 */
public class Demo06
{
    public static void main(String[] args)
    {
        charsetBufferTest();
    }
    /**
     * 字符缓冲流读取测试
     */
    public static void charsetBufferTest(){
        File file=new File("1.txt");
        Reader reader=null;
        try
        {
            reader= new BufferedReader(new FileReader(file));
            char[] car = new char[100];
            int len=0;
            while (-1!=(len=reader.read(car))){

                System.out.println(Arrays.toString(car));
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }finally
        {
            if(reader!=null){
                try
                {
                    reader.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }

    }
}
