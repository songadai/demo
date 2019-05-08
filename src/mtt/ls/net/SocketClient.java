package mtt.ls.net;

import java.io.*;
import java.net.Socket;

/**
 * 版权所有 (C) 2019-2029 长沙新时科技发展有限公司。保留所有权利。
 * 版本：
 * 修改记录：
 * 1、2019年05月08天，劉松创建。
 * socket编程客户端
 */
public class SocketClient
{
    public static void main(String[] args)
    {
        Socket client=null;
        BufferedReader in=null;
        BufferedWriter out=null;
        BufferedReader console=null;

        try{
            client=new Socket("localhost",8888);
            in=new BufferedReader(new InputStreamReader(client.getInputStream()));
            out=new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
            console=new BufferedReader(new InputStreamReader(System.in));
            while (true){
                System.out.println("nininnini");
                String msg=console.readLine();
                out.write(msg+"\n");
                out.flush();
                System.out.println("-----------");
                if("end".equals(msg)){
                    System.out.println("结束");
                    break;
                }
                System.out.println("服务器说:"+in.readLine());
            }
        }catch (IOException e){

        }finally
        {
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
            if(out!=null){
                try
                {
                    in.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            if(client!=null){
                try
                {
                    client.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            if(console!=null){
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
