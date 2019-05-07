package mtt.ls.io;

import java.io.*;

/**
 * 版权所有 (C) 2019-2029 长沙新时科技发展有限公司。保留所有权利。
 * 版本：
 * 修改记录：
 * 1、2019年05月07天，劉松创建。
 * 文件夹拷贝
 */
public class Demo04
{
    public static void main(String[] args)
    {
        File file1=new File("e:/iotest");
        File file2=new File("e:/iotest1");
        try
        {
            copyDetail(file1,file2);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    /**
     * 拷贝文件夹
     * @param src
     * @param dest
     * @throws IOException
     */
    public static void copyDetail(File src,File dest) throws IOException
    {
        if(src.isFile()){
            copy(src,dest);
        }
        else{
            //确保目标文件存在
            dest.mkdir();
            for(File sub:src.listFiles()){
                copyDetail(sub,new File(dest,sub.getName()));
            }

        }
    }

    /**
     * 拷贝文件
     * @param src
     * @param des
     * @throws IOException
     */
    public static void copy(File src,File des) throws IOException
    {
        if(!src.isFile()){
            System.out.println("只能拷贝文件");
            throw new IOException();
        }
        //输入流
        InputStream is=null;
        //输出流
        OutputStream os=null;
        try
        {
            is = new FileInputStream(src);

            os = new FileOutputStream(des);
            //每次拷贝car数组.
            byte[] car = new byte[1024*10];
            int len = 0;
            while (-1 != (len = is.read(car)))
            {
                os.write(car, 0, len);
            }
            os.flush();
        }finally
        {
            if(is!=null){
                is.close();
            }
            if(os!=null){
                os.close();
            }
        }

    }
}
