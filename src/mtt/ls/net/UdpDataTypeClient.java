package mtt.ls.net;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * 版权所有 (C) 2019-2029 长沙新时科技发展有限公司。保留所有权利。
 * 版本：
 * 修改记录：
 *  * 1、2019年05月08天，劉松创建。
 * udp通信发送double数据类型。
 */
public class UdpDataTypeClient
{
    /**
     * 发送double
     * @param args
     */
    public static void main(String[] args)
    {
        DatagramSocket client = null;

        double num=1.234;
        try
        {
            byte[] data=convert(1.234);
            client = new DatagramSocket(6666);
            client.send(new DatagramPacket(data,data.length,new InetSocketAddress("localhost",8888)));
            client.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    /**
     * 将double类型数据转化为字节数组
     * @param num
     * @return
     * @throws IOException
     */
    public static byte[] convert(double num) throws IOException
    {
        byte[] data=null;
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        DataOutputStream dataOutputStream=new DataOutputStream(byteArrayOutputStream);
        dataOutputStream.writeDouble(num);
        dataOutputStream.flush();
        data=byteArrayOutputStream.toByteArray();
        dataOutputStream.close();
        return data;

    }
}
