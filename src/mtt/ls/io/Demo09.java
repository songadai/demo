package mtt.ls.io;

import java.io.*;

/**
 * 版权所有 (C) 2019-2029 长沙新时科技发展有限公司。保留所有权利。
 * 版本：
 * 修改记录：
 * 1、2019年05月07天，劉松创建。
 *
 *
 * 数据流
 */
public class Demo09
{
    public static void main(String[] args)
    {
        dataStreamTest();
    }
    public static void dataStreamTest(){
        DataInputStream dis=null;
        DataOutputStream dos=null;
        BufferedInputStream bis=null;
        BufferedOutputStream bos=null;
        try
        {
            bis=new BufferedInputStream(new FileInputStream("1.txt"));
            bos=new BufferedOutputStream(new FileOutputStream("1.txt"));
            dos= new DataOutputStream(bos);
            dis= new DataInputStream(bis);
            dos.write(1);
            dos.writeDouble(233.34);
            dos.writeUTF("刘松");
            dos.flush();
            System.out.println(dis.read());
            System.out.println(dis.readDouble());
            System.out.println(dis.readUTF());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
