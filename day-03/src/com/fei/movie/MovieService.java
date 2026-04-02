package com.fei.movie;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovieService {
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
    //2.下架电影
    private void removeMovie() {
    }

    //7.修改电影
    private void updateMovie() {
    }

    //6.展示所有电影
    private void showAllmovies() {
        System.out.println("====展示所有电影====");
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }
    //5.下架某个明星的电影

    private void removeMovieByActor() {
        System.out.println("====下架某个明星的电影====");
        System.out.println("请输入明星名称：");
        String actor = sc.next();
        // 问题：明星不止演过一部电影，删多部
        for (int i = 0; i < movies.size(); i++) {
            Movie movie = movies.get(i);
            if (movie.getActor().contains(actor)){//不应该是equals而是包含
                movies.remove(i);
                System.out.println("下架成功！");
                //return;
                i--;
            }

        }
    }

    //根据电影名称查询电影
    public Movie queryMovieByName(String name) {
        for (Movie m : movies) {
            if (m.getName().equals(name)) {
                return m;
            }
        }
        return null;
    }
  //4.查询电影
    private void queryMovie() {
        System.out.println("====查询电影====");
        System.out.println("请输入电影名称：");
        String name = sc.next();
        //根据电影名称在集合里面查询电影对象，再返回对象
        //最好设计成一个方法
        Movie movie =queryMovieByName(name);
        if (movie != null){
            System.out.println(movie);//data已经包含toString()方法，所以可以直接打印对象
        }else {
            System.out.println("没有此电影！");
        }
    }

    //1.上架电影
    private void addMovie() {
        System.out.println("====上架电影====");
        //1.创建电影对象，封装电影信息
        Movie movie = new Movie();
        //2.给电影数据
        System.out.println("请输入电影名称：");
        movie.setName(sc.next());
        System.out.println("请输入电影评分：");
        movie.setScore(sc.nextDouble());
        System.out.println("请输入电影主演：");
        movie.setActor(sc.next());
        System.out.println("请输入电影导演：");
        movie.setDirector(sc.next());
        System.out.println("请输入电影价格：");
        movie.setPrice(sc.nextDouble());
        //3.将电影对象添加到集合中
        movies.add(movie);
        System.out.println("上架成功！");
    }
}
