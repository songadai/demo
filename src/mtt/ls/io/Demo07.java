package mtt.ls.io;

import java.io.UnsupportedEncodingException;

/**
 * 版权所有 (C) 2019-2029 长沙新时科技发展有限公司。保留所有权利。
 * 版本：
 * 修改记录：
 * 1、2019年05月07天，劉松创建。
 */
public class Demo07
{
    public static void testCharset(){
        String str="中国";
        try
        {
            byte[] bytes=str.getBytes("utf-8");
            String s=new String(bytes,"utf-8");
        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }
    }
}
