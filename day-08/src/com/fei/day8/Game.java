package com.fei.day8;

public class Game {
    public static void main(String[] args) {
        //目标：开发斗地主游戏
        //1.每张牌都是一个对象，定义牌类
        //2.游戏房间也是一个对象，定义房间类（准备54张牌，启动）
        Room room1 = new Room();
        room1.start();
    }
}
