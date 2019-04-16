package com.mazheng.chat.ChatServerUtil;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 入口 测试
 * @author mazheng
 * @date 2019/416
 *
 */
public class chatServer {
    //主函数入口
    public static void main(String[] args){

    }
    public void setupServer(int port) throws IOException {
        //创建一个服务器
        ServerSocket serverSocket = new ServerSocket(port);
        //打印当前服务器的端口号
        System.out.println("服务器创建成功,端口号:"+serverSocket.getLocalPort());
        while (true){
            //创建一个socker对象连接 等待进入
            Socket socket = serverSocket.accept();
            //进入成功后打印成功消息 打印连接的端口号
            System.out.println("进入一个客户机连接:"+socket.getRemoteSocketAddress().toString());
            //启动一个线程去处理这个对象

        }
    }

}
