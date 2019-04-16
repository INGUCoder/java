package com.mazheng.chat.ChatServerUtil;

import ch.qos.logback.classic.net.SocketReceiver;
import com.mazheng.chat.entity.Users;

import java.io.*;
import java.net.Socket;

/**每当有客户机和服务器连接 都要对应一个对象来进行数据传输
 * 从服务器的角度来看 这个类就是客户端
 * @author mazheng
 * @date 2019/4/16
 */
public class ServerThread  extends Thread{
    /**
     * 线程中的处理对象
     */
    private Socket client;
    /**
     * 输出流对象
     */
    private OutputStream outputStream;
    /**
     * 用户信息对象
     */
    private Users user;
    public ServerThread(Socket client){
        this.client = client;
    }
    public Users getUser(){
        return this.user;
    }

    @Override
    public void run() {
        try {

        }
        super.run();
    }

    public void processSocket() throws IOException {
        InputStream inputStream = client.getInputStream();
        outputStream = client.getOutputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

    }
}
