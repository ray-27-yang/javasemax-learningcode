package com.fei.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.List;

public class ClientChatFrame extends JFrame {
    public JTextArea smsContent = new JTextArea(23, 50);
    private JTextArea smsSend = new JTextArea(4, 40);
    public JList<String> onLineUsers = new JList<>();
    private JButton sendBn = new JButton("发送");
    //新全局变量
    private Socket socket;
    private String nickname;

    public ClientChatFrame() {
        initView();
        this.setVisible(true);
    }
//新代码
    public ClientChatFrame(String nickname, Socket socket) {
        this();//调上面的构造器，初始化界面信息
        //初始化数据，立马展示到窗口
        this.setTitle(nickname+"的聊天窗口");
        this.socket = socket;

        //立即把客户端的socket交给交给一个独立的线程，专门负责读取客户端socket从服务端收到的在线人数更新数据和群聊数据。
        new ClientReaderThread(socket,this).start();//还要把整个窗口对象送给线程，以便线程去处理展示

    }

    private void initView() {
        this.setSize(700, 600);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 关闭窗口，退出程序
        this.setLocationRelativeTo(null); // 窗口居中

        // 设置窗口背景色
        this.getContentPane().setBackground(new Color(0xf0, 0xf0, 0xf0));

        // 设置字体
        Font font = new Font("SimKai", Font.PLAIN, 14);

        // 消息内容框
        smsContent.setFont(font);
        smsContent.setBackground(new Color(0xdd, 0xdd, 0xdd));
        smsContent.setEditable(false);

        // 发送消息框
        smsSend.setFont(font);
        smsSend.setWrapStyleWord(true);
        smsSend.setLineWrap(true);

        // 在线用户列表
        onLineUsers.setFont(font);
        onLineUsers.setFixedCellWidth(120);
        onLineUsers.setVisibleRowCount(13);

        // 创建底部面板
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setBackground(new Color(0xf0, 0xf0, 0xf0));

        // 消息输入框
        JScrollPane smsSendScrollPane = new JScrollPane(smsSend);
        smsSendScrollPane.setBorder(BorderFactory.createEmptyBorder());
        smsSendScrollPane.setPreferredSize(new Dimension(500, 50));

        // 发送按钮
        sendBn.setFont(font);
        sendBn.setBackground(Color.decode("#009688"));
        sendBn.setForeground(Color.WHITE);

        // 按钮面板
        JPanel btns = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
        btns.setBackground(new Color(0xf0, 0xf0, 0xf0));
        btns.add(sendBn);

        // 给发送按钮绑定点击事件
        sendBn.addActionListener(e -> {
            //拿到消息发送框的内容
            String msg = smsSend.getText();
            //清空发送框
            smsSend.setText("");
            //把消息发送给服务端
            sendMsgToServer(msg);
        });



        // 添加组件
        bottomPanel.add(smsSendScrollPane, BorderLayout.CENTER);
        bottomPanel.add(btns, BorderLayout.EAST);

        // 用户列表面板
        JScrollPane userListScrollPane = new JScrollPane(onLineUsers);
        userListScrollPane.setBorder(BorderFactory.createEmptyBorder());
        userListScrollPane.setPreferredSize(new Dimension(120, 500));

        // 中心消息面板
        JScrollPane smsContentScrollPane = new JScrollPane(smsContent);
        smsContentScrollPane.setBorder(BorderFactory.createEmptyBorder());

        // 添加所有组件
        this.add(smsContentScrollPane, BorderLayout.CENTER);
        this.add(bottomPanel, BorderLayout.SOUTH);
        this.add(userListScrollPane, BorderLayout.EAST);
    }
//新代码,发送消息给服务端
    private void sendMsgToServer(String msg) {
        try {
            //1.从socket管道中得到一个特殊数据输入流
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            //2.把消息发送给服务端
            dos.writeInt(2);
            dos.writeUTF(msg);
            dos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new ClientChatFrame();
    }
    //新代码
    public void updateOnlineUsers(String[] onlineNames) {
        //把这个线程读取到的在线用户名称（数组中）展示到界面上
        onLineUsers.setListData(onlineNames);//调用这个界面组件的api，要求形参为数组
    }
    //新代码,更新群聊消息展示到界面
    public void setMsgToWin(String msg) {
        //把服务端发来的群聊消息，展示到界面上
        smsContent.append(msg);
    }
}