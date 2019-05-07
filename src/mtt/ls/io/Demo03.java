package mtt.ls.io;

import java.io.*;

/**
 * 版权所有 (C) 2019-2029 长沙新时科技发展有限公司。保留所有权利。
 * 版本：
 * 修改记录：
 * 1、2019年05月07天，劉松创建。
 * 文件的拷贝
 */
public class Demo03
{
    public static void main(String[] args)
    {
        File file1=new File("20190507103222.png");
        File file2=new File("290507103222.png");
        try
        {
            copy(file1,file2);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    /**
     * 将src的文件拷贝到des文件中
     * @param src
     * @param des
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
            byte[] car = new byte[100];
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
