/**
 * 版权所有 (C) 2019-2029 长沙新时科技发展有限公司。保留所有权利。
 * 版本：
 * 修改记录：
 * 1、2019年05月09天，劉松创建。
 */
package mtt.ls.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * nio入门案例
 */
public class Demo01
{
    public static void main(String[] args) throws IOException
    {
        //建立源头
        RandomAccessFile aFile=new RandomAccessFile("1.txt","rw");
        //获取通道
        FileChannel fileChannel=aFile.getChannel();
        //设置buff大小
        ByteBuffer buff = ByteBuffer.allocate(1024);
        int bytesRead=0;
        //每次将数据从通道写到到缓冲中，然后缓冲区读取.
        while ((bytesRead=fileChannel.read(buff))!=-1) {
            buff.flip();
            while (buff.hasRemaining()){
                System.out.println((char)buff.get());
            }
            buff.compact();
        }
        aFile.close();
    }
}
