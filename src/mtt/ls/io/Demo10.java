package mtt.ls.io;

import java.io.*;
import java.util.Date;

/**
 * 版权所有 (C) 2019-2029 长沙新时科技发展有限公司。保留所有权利。
 * 版本：
 * 修改记录：
 * 1、2019年05月07天，劉松创建。
 *
 * 对象流demo
 */
public class Demo10
{
    public static void main(String[] args)
            throws IOException, ClassNotFoundException
    {
        write();
        read();
    }
    /**
     * 使用对象流
     * @throws IOException
     */
    public static void write() throws IOException
    {
        BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream("1.txt"));
        ObjectOutputStream oos=new ObjectOutputStream(bos);
        oos.writeObject(new Date());
        oos.close();
        bos.close();
    }
    public static void read() throws IOException, ClassNotFoundException
    {
        BufferedInputStream bis=new BufferedInputStream(new FileInputStream("1.txt"));
        ObjectInputStream ois=new ObjectInputStream(bis);
        System.out.println(ois.readObject());
        ois.close();
        bis.close();
    }
}
