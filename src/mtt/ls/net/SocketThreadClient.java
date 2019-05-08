package mtt.ls.net;

import java.io.*;
import java.net.Socket;

/**
 * 版权所有 (C) 2019-2029 长沙新时科技发展有限公司。保留所有权利。
 * 版本：
 * 修改记录：
 * 1、2019年05月08天，劉松创建。
 * 客户端socket线程类,多个客户端线程请求
 */
public class SocketThreadClient implements Runnable
{
    private Socket socket;
    private BufferedReader in;
    private BufferedWriter out;
    private BufferedReader console;

    public SocketThreadClient(Socket socket)
    {
        this.socket = socket;
    }

    public static void main(String[] args)
    {
        try
        {
            Socket socket=new Socket("localhost",9999);
            for (int i = 0; i <3 ; i++)
            {
               new Thread(new SocketThreadClient(socket)).start();
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
        sendAndReceive();
    }

    /**
     * 发送消息
     */
    public void sendAndReceive(){
        try
        {
            console=new BufferedReader(new InputStreamReader(System.in));
            out=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String temp="";
            while (true) {
                temp=console.readLine();
                System.out.println("已从控制台获取消息"+temp);
                out.write(temp+"\n");
                out.flush();
                System.out.println("已发送消息"+temp);
                if("END".equals(temp)){
                    System.out.println("客户端请求断开");
                    break;
                }
                temp=in.readLine();
                System.out.println("服务器回应"+temp);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }finally
        {
            if (out!=null)
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
            if (console!=null)
            {
                try
                {
                    console.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }


}
