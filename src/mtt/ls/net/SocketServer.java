package mtt.ls.net;

import java.io.*;
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
        BufferedWriter out=null;
        BufferedReader in=null;
        try
        {
            //创建套接字
            server=new ServerSocket(8888);
            System.out.println("已经建立监听");
            Socket socket=server.accept();
            in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            while (true){
                String msg1=in.readLine();
                System.out.println("客户端说:"+msg1);
                String msg="你好，我是服务器";
                out.write(msg+"\n");
                out.flush();
                if("end".equals(msg1)){
                    break;
                }
            }
            //使用流的方式发送数据
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }finally
        {
            if(out!=null){

                try
                {
                    out.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            if(in!=null){
                try
                {
                    in.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }

        }
    }
}
