package com.fei.movie;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class MovieService2 {
    //4.准备集合容器，存储电影对象
    private static List<Movie> movies = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);
    public void start() {
        //3.准备操作界面:cmd
        while (true) {
            System.out.println("====电影管理系统====");
            System.out.println("1.上架电影");
            System.out.println("2.下架电影");
            System.out.println("3.查询电影");
            System.out.println("4.下架某个明星的电影");
            System.out.println("5.exit");
            System.out.println("6.展示所有电影");
            System.out.println("7.修改电影");
            System.out.println("请您输入操作命令：");
            String command = sc.next();
            switch (command){
                case "1":
                    addMovie();//独立功能独立成方法
                    break;
                case "2":
                    removeMovie();//作业
                    showAllmovies();
                    break;
                case "3":
                    queryMovie();
                    break;
                case "4":
                    removeMovieByActor();//注意并发修改异常问题
                    showAllmovies();
                    break;
                case "5":
                    System.out.println("退出成功！");
                    return;//退出方法
                case "6":
                    showAllmovies();
                    break;
                case "7":
                    updateMovie();//作业
                    showAllmovies();
                    break;
                default:
                    System.out.println("输入命令有误，请重新输入！");
            }
        }
    }
    //修改电影
    private void updateMovie() {
    }

    private void removeMovieByActor() {
        System.out.println("请输入演员名称");
        String actor = sc.next();
        Iterator<Movie> it = movies.iterator();
        while (it.hasNext()){
            if(it.next().getActor().equals(actor)){
                it.remove();
            }
        }
    }

    //根据电影名称查询电影
    private void queryMovie() {
        System.out.println("请输入要查询的电影名称：");
        for (int i = 0; i < movies.size(); i++) {
            Movie m = movies.get(i);
            if (sc.next().equals(m.getName())) {
                System.out.println(m);
            }
        }
    }

    private void removeMovie() {
        System.out.println("===请输入要删除的电影信息==");
        boolean a = false;
        //用for循环可以得到索引
        for (int i = 0; i < movies.size(); i++) {
            Movie mv = movies.get(i);
            if (sc.next().equals(mv.getName())){
                movies.remove(i);
                a = true;
            }
        }
        if (a){
            System.out.println("删除成功");
        }else {
            System.out.println("删除失败");
        }
    }

    private void showAllmovies() {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    private void addMovie() {
        System.out.println("====请输入电影信息=====");
        Movie mv = new Movie();//创建电影对象，封装电影数据

        System.out.println("请输入电影名字");
        mv.setName(sc.next());
        System.out.println("请输入电影分数");
        mv.setScore(sc.nextDouble());
        System.out.println("请输入电影主演：");
        mv.setActor(sc.next());
        System.out.println("请输入电影导演：");
        mv.setDirector(sc.next());
        System.out.println("请输入电影价格：");
        mv.setPrice(sc.nextDouble());

        movies.add(mv);
        System.out.println("上架成功");

    }

}
