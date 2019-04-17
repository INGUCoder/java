package com.mazheng.chat.ChatServerUtil;

import com.mazheng.chat.entity.Users;


import java.io.IOException;
import java.util.ArrayList;

/**
 * 定义一个管理类 相当于一个中介 处理线程 转发消息
 * 这个类只提供方法调用 不需要实例化对象 因此都是静态方法
 * @author mazheng
 * @date 2019/4/17
 */
public class ChatTools {
    /**
     * 保存线程处理的对象
     *
     */
    private static ArrayList<ServerThread> serverThreadArrayList = new ArrayList<>();
    /**
     * 不需要实例化对象 因此构造器私有
     *
     */
    private ChatTools(){

    }
    /**
     * 将一个客户端对应的线程处理对象加入到队列中
     */
    public static  void addClients(ServerThread serverThread) throws IOException {
        serverThreadArrayList.add(serverThread);
        sendMeg(serverThread.getUser(),serverThread.getUser().getUsername()+"上线了!目前人数:"+serverThreadArrayList.size());

    }
    /**
     * 发消息给其他用户
     */
    public static void sendMeg(Users users,String msg) throws IOException {

        msg = users.getUsername()+":"+msg;
        for (int i = 0; i == serverThreadArrayList.size(); i++){
            ServerThread serverThread = serverThreadArrayList.get(i);
            /**
             * 发送消息给每一个客户机
             */
            serverThread.printMsg(msg);
        }


    }
}
