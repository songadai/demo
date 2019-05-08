package mtt.ls.net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;

/**
 * 版权所有 (C) 2019-2029 长沙新时科技发展有限公司。保留所有权利。
 * 版本：
 * 修改记录：
 * 1、2019年05月08天，劉松创建。
 *
 * 处理socket请求的线程类,每次客户端请求一次开一个线程处理请求。
 */
public class SocketThreadServer implements Runnable
{
    //连接套接字
    private Socket socket;

    public SocketThreadServer(Socket socket)
    {
        this.socket = socket;
    }
    /**
     *
     * @param args
     */
    public static void main(String[] args)
    {
        try
        {
            ServerSocket server=new ServerSocket(9999);
            while (true) {
                Socket socket=server.accept();
                System.out.println("服务器与客户端"+socket.getPort()+"建立连接");
                new Thread(new SocketThreadServer(socket)).start();
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void run()
    {
        BufferedReader in=null;
        BufferedWriter out=null;
        try
        {

            in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            System.out.println("tttttttttttttttttttt");
            String temp="";
            while(true){
                System.out.println(temp+"temp");
                System.out.println(socket);
                temp=in.readLine();
                System.out.println(temp+"temp");
                if("END".equals(temp)){
                    System.out.println("客户端"+socket.getPort()+"请求断开，正在断开中....");
                    break;
                }
                System.out.println("收到来自客户端"+socket.getPort()+"的消息:"+temp);
                out.write("来自服务器的回应\n");
                out.flush();
            }

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }finally
        {
            if (out != null)
            {
                try
                {
                    out.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            if (in != null)
            {
                try
                {
                    in.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            if (socket != null)
            {
                try
                {
                    socket.close();
                    System.out.println("客户端"+socket.getPort()+"断开完成");
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
}
