package com.fei.day8;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Card {
    private String number;
    private String color;
    private int value;//牌值，牌的大小

    @Override
    public String toString() {
        return number + color;
    }
}
