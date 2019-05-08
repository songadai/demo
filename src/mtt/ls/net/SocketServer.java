package mtt.ls.net;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 版权所有 (C) 2019-2029 长沙新时科技发展有限公司。保留所有权利。
 * 版本：
 * 修改记录：
 * 1、2019年05月08天，劉松创建。
 * socket编程服务端
 */
public class SocketServer
{
    public static void main(String[] args)
    {
        ServerSocket server=null;
        DataOutputStream dataOutputStream=null;
        try
        {
            //创建套接字
            server=new ServerSocket(8888);
            Socket socket=server.accept();
            System.out.println("已接收到客户端请求,准备响应");
            String msg="我是服务端发送的数据";
            //使用流的方式发送数据
            dataOutputStream=new DataOutputStream(socket.getOutputStream());
            dataOutputStream.writeUTF(msg);
            dataOutputStream.flush();


        }
        catch (IOException e)
        {
            e.printStackTrace();
        }finally
        {
            if(dataOutputStream!=null){

                try
                {
                    dataOutputStream.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
}
