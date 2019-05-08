package mtt.ls.net;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * 版权所有 (C) 2019-2029 长沙新时科技发展有限公司。保留所有权利。
 * 版本：
 * 修改记录：
 * 1、2019年05月08天，劉松创建。
 *
 * udp通信接受double数据类型。
 */
public class UdpDataTypeServer
{
    public static void main(String[] args)
    {
        DatagramSocket server= null;
        try
        {
            server = new DatagramSocket(8888);
            byte[] container=new byte[1024];
            DatagramPacket datagramPacket = new DatagramPacket(container,
                    container.length);
            server.receive(datagramPacket);
            byte[] data = datagramPacket.getData();

            System.out.println(convert(data));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }finally
        {
            if(server!=null){
                server.close();
            }
        }
    }

    /**
     * 将字节数组转化为double数据类型。
     * @param data
     * @return
     * @throws IOException
     */
    public static double convert(byte[] data) throws IOException
    {
        double num=0;
        ByteArrayInputStream byteInputStream = new ByteArrayInputStream(data);
        DataInputStream dataInputStream = new DataInputStream(byteInputStream);
        num=dataInputStream.readDouble();
        dataInputStream.close();
        return num;

    }
}
