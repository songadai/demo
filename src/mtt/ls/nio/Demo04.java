/**
 * 版权所有 (C) 2019-2029 长沙新时科技发展有限公司。保留所有权利。
 * 版本：
 * 修改记录：
 * 1、2019年05月09天，劉松创建。
 */
package mtt.ls.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * channel 通道练习
 * 通道的主要实现类
 * 1.filechannel
 * 2.SockCHannel
 * 3.serverChannel
 * 4.DatagramChannel
 *
 * 三、如何获取通道
 * 1.getChannel()方法
 * FileInputStream/FileOutputStream
 * RandAccessFile
 *
 * 网络通道:
 * Socket
 * ServerSocket
 * DataGramSocket
 * 2.jdk 1.7中的NIO 提供一个静态方法open()
 * 3.new ByteChannel().
 */
public class Demo04
{
    public static void main(String[] args) throws IOException
    {
        openTest();
    }

    /**
     * 内存映射文件读取文件
     * @throws IOException
     */
    public static void openTest() throws IOException
    {
        FileChannel inChanner = FileChannel.open(Paths.get("1.txt"), StandardOpenOption.READ);
        FileChannel outChanner = FileChannel.open(Paths.get("2.txt"),
                StandardOpenOption.WRITE,
                StandardOpenOption.READ,
                StandardOpenOption.CREATE);
        MappedByteBuffer inMappedBuf = inChanner.map(FileChannel.MapMode.READ_ONLY,0,inChanner.size());
        MappedByteBuffer outMappedBuf= outChanner.map(FileChannel.MapMode.READ_WRITE,0,inChanner.size());
        //直接从缓冲区进行数据读写.
        byte[] dst = new byte[inMappedBuf.limit()];
        inMappedBuf.get(dst);
        outMappedBuf.put(dst);
        inChanner.close();
        outChanner.close();
    }
    public static void test() throws IOException
    {
        /**
         * 复制文件
         */
        RandomAccessFile fis=new RandomAccessFile("1.txt","rw");
        RandomAccessFile fos=new RandomAccessFile("2.txt","rw");
        FileChannel inChannel=fis.getChannel();
        FileChannel outChannel=fos.getChannel();
        //建立缓冲区
        ByteBuffer buff=ByteBuffer.allocate(1024);
        //将通道中的数据存入缓冲区
        while (inChannel.read(buff)!=-1) {
            buff.flip();
            outChannel.write(buff);
            buff.clear();
        }
        outChannel.close();
        inChannel.close();
        fos.close();
        fis.close();
    }

}
