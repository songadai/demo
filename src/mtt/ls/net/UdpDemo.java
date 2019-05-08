package mtt.ls.net;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * 版权所有 (C) 2019-2029 长沙新时科技发展有限公司。保留所有权利。
 * 版本：
 * 修改记录：
 * 1、2019年05月07天，劉松创建。
 * udp编程基础
 */
public class UdpDemo
{
    public static void main(String[] args)
    {
        clientByUdp();
    }
    /**
     * UDP客户端
     * 1.创建udp套接字
     * 2.准备数据
     * 3.打包数据
     * 4.发送数据
     * 5.释放资源
     */
    public static void clientByUdp(){
        DatagramSocket client=null;
        try
        {
            //1.创建套接字
            client = new DatagramSocket(12345);
            //2.准备数据
            String msg="udp编程";
            byte[] data = msg.getBytes("utf-8");
            //3.打包数据
            DatagramPacket datagramPacket=new DatagramPacket(data,data.length,new InetSocketAddress("localhost",8888));
            client.send(datagramPacket);

        }
        catch (SocketException | UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }finally
        {
            //释放资源
            if(client!=null){
                client.close();
            }
        }
    }

    /**
     * udp服务端
     * 1.创建udp套接字
     * 2.准备接受容器
     * 3.接受数据
     * 4.分析数组
     * 5.释放资源
     */
    public static void serverByUdp(){
        DatagramSocket server=null;
        try
        {
            //创建套接字
            server=new DatagramSocket(8888);
            //接受数据包报文
            byte[] container = new byte[1024];
            DatagramPacket packet = new DatagramPacket(container,
                    container.length);
            server.receive(packet);
            System.out.println(new String(packet.getData(),0,packet.getLength()));
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
}
