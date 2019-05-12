/**
 * 版权所有 (C) 2019-2029 长沙新时科技发展有限公司。保留所有权利。
 * 版本：
 * 修改记录：
 * 1、2019年05月09天，劉松创建。
 */
package mtt.ls.nio;

import java.nio.ByteBuffer;

/**
 * buffer练习
 */
public class Demo03
{
    public static void main(String[] args)
    {
        String str="abdfdf";
        ByteBuffer buff=ByteBuffer.allocate(1024);
        buff.put(str.getBytes());
        System.out.println(buff.limit());
        //读写模式翻转
        buff.flip();
        System.out.println(buff.limit());
        buff.get();
        System.out.println((char)buff.get());
        System.out.println(buff.limit());
        byte[] bytes = new byte[buff.limit()];
        buff.get(bytes,0,2);
        System.out.println(new String(bytes,0,2));
    }
}
