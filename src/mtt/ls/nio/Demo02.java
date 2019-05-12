/**
 * 版权所有 (C) 2019-2029 长沙新时科技发展有限公司。保留所有权利。
 * 版本：
 * 修改记录：
 * 1、2019年05月09天，劉松创建。
 */
package mtt.ls.nio;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
/**
 * nio transfrom()
 * nio transto()
 */
public class Demo02
{
    public static void main(String[] args)
    {
        try
        {
            transfrommTest();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    /**
     *通过transfrom把源通道的数据转移到filechannel
     */
    public static void transfrommTest() throws IOException
    {
        RandomAccessFile from=new RandomAccessFile("1.txt","rw");
        RandomAccessFile to=new RandomAccessFile("2.txt","rw");
        FileChannel fromChannel=from.getChannel();
        FileChannel toChannel=to.getChannel();
        toChannel.transferFrom(fromChannel,0,fromChannel.size());

    }
    /**
     * 通过transto把源通道的数据转移到filechannel
     */
    public static void tranToTest() throws IOException
    {
        RandomAccessFile from=new RandomAccessFile("1.txt","rw");
        RandomAccessFile to=new RandomAccessFile("2.txt","rw");
        FileChannel fromChannel=from.getChannel();
        FileChannel toChannel=to.getChannel();
        fromChannel.transferTo(0, toChannel.size(),toChannel);

    }
}
