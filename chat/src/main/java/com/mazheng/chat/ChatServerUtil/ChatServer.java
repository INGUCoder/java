package com.mazheng.chat.ChatServerUtil;

import com.mazheng.chat.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 入口 测试
 * @author mazheng
 * @date 2019/4/16
 *
 */
public class ChatServer {

    /**
     * 测试函数
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        ChatServer chatServer = new ChatServer();
        chatServer.setupServer(9000);
    }
    public void setupServer(int port) throws IOException {
        /**
         * 创建一个服务器
         */
        ServerSocket serverSocket = new ServerSocket(port);
        /**
         * 打印当前服务器的端口号
         */
        System.out.println("服务器创建成功,端口号:"+serverSocket.getLocalPort());
        while (true){
            /**
             *  创建一个socket对象连接 等待进入
             */
            Socket socket = serverSocket.accept();
            /**
             * 进入成功后打印成功消息 打印连接的端口号
             */
            System.out.println("进入一个客户机连接:"+socket.getRemoteSocketAddress().toString());
            /**
             * 启动一个线程去处理这个对象
             */
            ServerThread serverThread = new ServerThread(socket);
            serverThread.start();

        }
    }

}
