package com.fei.demo4;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Star implements StarService{
    private String name;

    @Override
    public void sing(String name){
        System.out.println(this.name + "表演唱歌" + name);
    }
    @Override
    public String dance(){
        System.out.println(this.name + "表演跳舞，魅力四射！");
        return "thks";
    }
}
