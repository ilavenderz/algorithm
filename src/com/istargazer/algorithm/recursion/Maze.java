package com.istargazer.algorithm.recursion;

import java.util.Arrays;

/**
 * 走迷宫
 * 以矩形二维数组grid表示解空间--迷宫(maze)，0表示通路，1表示墙。设迷宫的入口实在左上角，即grid[0][0],
 * 出口在右下角,人可以在沿着相加左右4个方向走到邻近的方格(不能对角线移动),如果如果迷宫找到/走到出口则返回
 * true，否则意味着迷宫是不能狗走出的。
 *
 *
 * 递归策略
 * 如果从(0,0)点能够走出迷宫，则一定能狗从它的某一个相邻的点走出迷宫。递归的，最后从右下角grid[grid.length-1][grid[0].length-1]
 * 走出去。因此，方法go(int x,int y)是一个递归方法，方法体中将调用4个方向邻近点的go()方法。递归出口为右下角点对
 * go()方法的调用
 *
 * 试探与回溯
 * 试探意味着从一个点能够走到下一个点，而对已经试探过的点标记为TRIED(这里去值为7)；显然，有一些相邻点是不值得试探的，
 * 1 相邻点是墙(1)
 * 2 已经试探过的
 * 3 不再grid范围之内的
 *
 * 回溯方法调用栈完成，不需要做额外的事。
 *
 */
public class Maze {
    private static final int TRIED = 7; // 已试探的点
    private static final int PATH = 8; // 可行的路径
    int[][] grid = {{0,0,0,1,0,0,1,1,1,0,0,0,0},
                    {0,1,0,0,0,1,0,0,0,0,1,1,0},
                    {1,1,1,1,0,1,0,1,0,1,0,1,1},
                    {0,0,0,0,0,0,0,1,0,1,0,0,0},
                    {0,1,0,1,1,1,1,0,0,0,1,1,0},
                    {0,1,0,0,0,0,0,0,0,0,0,0,0},
                    {0,1,1,1,1,1,1,1,1,1,1,1,1},
                    {0,0,0,0,0,0,0,0,0,0,0,0,0}};

    /**
     * 判断下一个点是否是通路
     * @param grid grid[y][x] 迷宫
     * @param x 当前x轴坐标
     * @param y 当前y轴坐标
     * @return
     */
    private final boolean isWorthTrying(int[][] grid,int x,int y) {
        boolean in = (y >= 0) && (y < grid.length) && (x >= 0) && (x < grid[y].length);
        return in && (grid[y][x] == 0);
    }

    /**
     * 按下、右、上、左进行尝试
     * @param grid
     * @param x
     * @param y
     * @return
     */
    public boolean go(int[][] grid,int x,int y) {
        boolean done = false;
        if(isWorthTrying(grid,x,y)) {
            grid[y][x] = TRIED;
            if(x == (grid[grid.length - 1].length - 1) && y == (grid.length - 1)) {
                done = true;
            } else {
                done = go(grid, x,y + 1); // 下
                if(!done) done = go(grid,x + 1, y); // 右
                if(!done) done = go(grid, x, y - 1); // 上
                if(!done) done = go(grid, x - 1, y); // 左
            }
            if(done) grid[y][x] = PATH;
        }
        return done;
    }

    public static void main(String[] args) {
        Maze m = new Maze();
        System.out.println(m.go(m.grid,0,0));
        for(int[] arr : m.grid){
            System.out.println(Arrays.toString(arr));
        }
    }

}
