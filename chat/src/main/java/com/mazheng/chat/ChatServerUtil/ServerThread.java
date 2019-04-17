package com.mazheng.chat.ChatServerUtil;

;
import com.mazheng.chat.dao.DaoTools;
import com.mazheng.chat.dao.UserMapper;
import com.mazheng.chat.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;
import java.net.Socket;

/**
 * 每当有客户机和服务器连接 都要对应一个对象来进行数据传输
 * 从服务器的角度来看 这个类就是客户端
 *
 * @author mazheng
 * @date 2019/4/16
 */

public class ServerThread extends Thread {
    @Autowired
     private UserMapper userMapper;
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



    public ServerThread(Socket client) {
        this.client = client;
    }

    public Users getUser() {
        return this.user;
    }

    @Override
    public void run() {
        try {
            processSocket();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 打印信息
     *
     * @param msg
     * @throws IOException
     */
    public void printMsg(String msg) throws IOException {
        msg = msg;
        outputStream.write(msg.getBytes());
        outputStream.flush();
    }

    public void processSocket() throws IOException {
        InputStream inputStream = client.getInputStream();
        outputStream = client.getOutputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        printMsg("欢迎来到聊天室,请输入账号:");
        String email = bufferedReader.readLine();

        /**
         * test
         */
        System.out.println("test账号" + email);
        printMsg("请输入密码:");
        String password = bufferedReader.readLine();
        System.out.println("password");

        /**
         * 创建一个用户
         */
        user = new Users();
        user.setEmail(email);
        user.setPassword(password);
        System.out.println(user+"-----TEST----");
        System.out.println(userMapper+"Test");

        /**
         *在数据库中验证用户
         */
        DaoTools daoTools = new DaoTools();
        boolean loginStatus = daoTools.check(user, email);
        if (!loginStatus) {
            this.closeClient();
            return;
        }
        ChatTools.addClients(this);
        String input = bufferedReader.readLine();
        while (!input.equals("quit")) {
            ChatTools.sendMeg(this.user, input);
            input = bufferedReader.readLine();
        }
        ChatTools.sendMeg(this.user, "bye");
        this.closeClient();


    }

    /**
     * 关闭当前客服端和服务端的连接
     *
     * @throws IOException
     */
    public void closeClient() throws IOException {
        client.close();
    }
}
