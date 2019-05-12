/**
 * 版权所有 (C) 2019-2029 长沙新时科技发展有限公司。保留所有权利。
 * 版本：
 * 修改记录：
 * 1、2019年05月10天，劉松创建。
 */
package mtt.ls.nio.niochat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.HashSet;
import java.util.Set;

/**
 * 使用nio实现多人在线聊天
 */
public class Server
{
    //服务端选择器
    private Selector selector;
    //用来存储用户名
    private Set<String> users=new HashSet<>();
    //serverSocketChannel的SelectionKey
    private SelectionKey serverKey;
    //端口
    private static final int PORT=7890;
    public void init() throws IOException
    {
        //获取选择器
        selector=Selector.open();
        //服务器套接字通道
        ServerSocketChannel serverSocketChannel=ServerSocketChannel.open();
        //将服务器套接字绑定端口
        serverSocketChannel.socket().bind(new InetSocketAddress(PORT));
        //设置非阻塞通信
        serverSocketChannel.configureBlocking(false);
        //将服务器套接字注册到选择器,注册监听事件.
        serverSocketChannel.register(selector,SelectionKey.OP_ACCEPT);
    }
    public void handle(){
        
    }

}
