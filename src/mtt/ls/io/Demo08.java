package mtt.ls.io;

import java.io.ByteArrayInputStream;

/**
 * 版权所有 (C) 2019-2029 长沙新时科技发展有限公司。保留所有权利。
 * 版本：
 * 修改记录：
 * 1、2019年05月07天，劉松创建。
 * 字节数组流练习
 */
public class Demo08
{
    public static void main(String[] args)
    {
        byteStreamTest();
    }
    public static void byteStreamTest(){
        //1.定义数据源
        byte[] bytes = "asdfljsdf".getBytes();
        //使用ByteArrayInputs
        ByteArrayInputStream bis=new ByteArrayInputStream(bytes);
        int temp=0;
        StringBuilder sb=new StringBuilder();
        while ((temp=bis.read())!=-1){
            sb.append((char)temp);
        }
        System.out.println(sb);
    }
}
