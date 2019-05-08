package mtt.ls.net;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 版权所有 (C) 2019-2029 长沙新时科技发展有限公司。保留所有权利。
 * 版本：
 * 修改记录：
 * 1、2019年05月07天，劉松创建。
 * 使用url爬虫获取源码
 */
public class URLDemo
{
    public static void main(String[] args)
    {
        try
        {
            getSource();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    /**
     * 获取百度源码
     */
    public static void getSource() throws IOException
    {
        URL url=new URL("http://www.baidu.com");
        //定义字符缓冲输入流
        BufferedReader br=new BufferedReader(new InputStreamReader(
                url.openStream(),"utf-8"
        ));
        //定义字符缓冲输入流
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("e:/iotest/1.html"),"utf-8"
        ));
        //开始操作
        String str=null;
        while ((str=br.readLine())!=null){
            bw.append(str);
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
