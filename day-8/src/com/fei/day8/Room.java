package com.fei.day8;

import java.util.*;

public class Room {
    //1.准备好54张牌，给房间使用：定义一个集合容器装牌
    private List<Card> allCards = new ArrayList<>();
    //2.初始化54张牌，并添加到集合中,用实例代码块来做
    {
        //3.准备点数
        String[] numbers = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K","A", "2"};
        //4.准备花色    面值   1    2    3    4    5    6    7    8    9    10...
        String[] colors = {"♠", "♥", "♣", "♦"};
        //5.组合点数和花色成为牌对象加到集合中去
        int count = 0;
        for (String number : numbers) {
            count++;
            for (String color : colors) {
                //6.创建牌对象
                Card card = new Card(number, color,count);
                //7.添加到集合中
                allCards.add(card);
            }
        }
        //8.添加大小王
//        allCards.add(new Card("BigKing", ""));
//        allCards.add(new Card("SmallKing",""));
        Collections.addAll(allCards, new Card("BigKing", "",++count), new Card("SmallKing","",++count));
        System.out.println("新牌是" + allCards);//为什么不会打印面值：因为没有重写toString方法重写了里面不会打印
    }
    public void start() {
        //9.洗牌,启动后打乱顺序
        Collections.shuffle(allCards);
        System.out.println("洗牌后：" + allCards);
        //10.发牌:定义三个玩家：简隋英=【】，深见青=【】，丁汉白=【】
        Map<String, List<Card>> players = new HashMap<>();
        List<Card> player1 = new ArrayList<>();
        players.put("简隋英", player1);

        List<Card> player2 = new ArrayList<>();
        players.put("深见青", player2);

        List<Card> player3 = new ArrayList<>();
        players.put("丁汉白", player3);
        //allCards= [3♥, 2♥, Q♣, 9♠, A♣, 10♥, 9♣, K♠, 5♠, J♠...
        //只发出去51张 0   1   2   3   4   5    6   7   8   9 ...
        for (int i = 0; i < allCards.size() - 3; i++) {
            //获取当前牌
            Card card = allCards.get(i);
            //判断这张牌发给谁
            if (i % 3 == 0) {
                player1.add(card);
            } else if (i % 3 == 1) {
                player2.add(card);
            } else {
                player3.add(card);
            }
        }

        //11.拿三张底牌
        List<Card> dipai = allCards.subList(allCards.size() - 3, allCards.size());//下标[51,54)==[51,52,53]
        System.out.println("底牌是：" + dipai);
        //12.抢地主
        player3.addAll(dipai);
        //13.对牌进行排序（作业）,排序有多种方法，全部试一遍，并且选择一种来背一下
        //方法一:Stream流，但是不能直接改变原来的集合，只能返回一个排序后的集合，还得把排好的重新换进去
//        player1.stream().sorted(new Comparator<Card>() {
//            @Override
//            public int compare(Card o1, Card o2) {
//                return 0;
//            }
//        })
        //方法二:每个都要重写比较器里面的方法，直接创建一个比较方法
//        Collections.sort(player1, new Comparator<Card>() {
//            @Override
//            public int compare(Card o1, Card o2) {
//
//            }
//        });
        sortCards(player1);
        sortCards(player2);
        sortCards(player3);
        //14.看牌：遍历集合，获取玩家名称和牌（用键值对的方法）
        for (Map.Entry<String, List<Card>> entry : players.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

    }

    private void sortCards(List<Card> player) {
        Collections.sort(player, new Comparator<Card>() {
            @Override
            public int compare(Card o1, Card o2) {
                //1.比较点数:怎么比较？
                //o1 3♥
                //o2 2♥
                return o2.getValue() - o1.getValue();
            }
        });//这一串可简化
    }
}
