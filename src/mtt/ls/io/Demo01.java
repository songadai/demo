package mtt.ls.io;

import java.io.File;

/**
 * 版权所有 (C) 2019-2029 长沙新时科技发展有限公司。保留所有权利。
 * 版本：
 * 修改记录：
 * 1、2019年05月07天，劉松创建。
 * 文件的相对路径和绝对路径
 */
public class Demo01
{
    public static void main(String[] args){
        String path="testio";
        File src=new File(path);
        System.out.println(src.getName());
        System.out.println(src.getPath());
        System.out.println(src.getAbsoluteFile());
    }
}
