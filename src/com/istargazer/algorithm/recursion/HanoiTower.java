package com.istargazer.algorithm.recursion;

import java.util.Stack;

/**
 * 汉诺塔
 * 汉诺塔(Tower of HanoiTower)源于印度传说中，大梵天创造世界时造了三根金钢石柱子，
 * 其中一根柱子自底向上叠着64片黄金圆盘。大梵天命令婆罗门把圆盘从下面开始按大小顺序重新摆放在另一根柱子上。
 * 并且规定，在小圆盘上不能放大圆盘，在三根柱子之间一次只能移动一个圆盘。
 *
 * 递归思想
 * 上面的n-1个盘子被看成粘在一起的小盘子，而下面的是一个大盘子。
 *
 * 递归算法
 * 结束条件
 * 起始柱子只有一个盘子，将他移动到目标柱子
 * 递归式：
 * 1 将上面的n-1个盘子从出发地移动到中转辅助柱子
 * 2 将第n个盘子移动到目标柱子
 * 3 将第n-1个盘子从辅助柱子移动到目标柱子
 */
public class HanoiTower {

    /**
     * 将第n个盘子，从from柱子移动到to柱子
     * @param number 第n个盘子
     * @param from from 第n个盘子原先所在的柱子
     * @param to 第n个盘子将要移动到的柱子
     */
    private static void move(int number, char from, char to) {
        System.out.println("move " + number + " from " + from + " to " + to + ".");
    }

    /**
     *
     * @param number 第n个盘子
     * @param from from 第n个盘子原先所在的柱子
     * @param to 第n个盘子将要移动到的柱子
     * @param temp 辅助柱子
     */
    private static void recursion(int number,char from, char to, char temp) {
        if(1 != number) {
            recursion(number - 1,from,temp,to); // 将第n-1个盘子移动到辅助柱子上
            move(number,from,to); // 将第n个盘子移动到目标柱子上
            recursion(number - 1,temp,to,from); // 将第n-1个盘子移动到目标柱子上
        } else {
            move(number, from, to);
        }
    }

    /**
     * 画出汉诺塔
     * @param number 汉诺塔层数
     */
    private static void drawHanoiTower(int number) {
        for(int height = 0; height <= number; height++) {
            // 打印汉诺塔第height层 从第二层开始有盘子
            int space = number - height;
            // 打印空白
            for(int spaceIndex = 0; spaceIndex < space; spaceIndex++){
                System.out.print(" ");
            }
            // 打印盘子左边部分
            for(int saucerIndex = 0; saucerIndex < height; saucerIndex++){
                System.out.print("*");
            }
            // 打印柱子
            System.out.print("|");
            // 打印盘子右边部分
            for(int saucerIndex = 0; saucerIndex < height; saucerIndex++){
                System.out.print("*");
            }
            // 打印空白
            for(int spaceIndex = 0; spaceIndex < space; spaceIndex++){
                System.out.print(" ");
            }
            System.out.println(" | " + height);
        }
    }

    /**
     * 初始化 汉诺塔
     * @param number 汉诺塔层数
     * @param from 起始柱子
     * @param to 目标柱子
     * @param temp 中转柱子
     */
    public static void initHanoiTower(int number,char from,char to,char temp) {
        drawHanoiTower(number);
        recursion(number,from,to,temp);
    }

    public static void main(String[] args) {
        HanoiTower.initHanoiTower(4,'a','c','b');
        Stack<Integer> st = new Stack<>();
    }
}
