package com.istargazer.algorithm.recursion;

public class EightQueens {
    private static final int N = 8; // 皇后数量
    private static int[][] board = new int[N][N]; // 棋盘
    private static int[] queens = new int[N]; // queens的元素为各皇后的x坐标,y坐标由queens的索引承担
    private boolean ok = false; // 用于找出一个解救结束程序的情况
    private int count = 0;

    public void putQueen(int i){
        int y = i; // 第i行
        for(int x = 0; x < N; x++){
            if(0 == board[y][x]){ // 可以防止皇后
                queens[y] = x; // x坐标
                markCanAttackBy(y,x);
                if(y == N - 1){
                    print(++count);
                    ok = true;
                }else{ // 继续放置下一行的皇后
                    putQueen(y + 1);
                    if(ok)
                        break;
                }
                unMark(y,x); // 回溯--去掉第i个皇后标记的攻击点,重新放置第i个皇后
            }
        }
    }

    /**
     * 将能狗被本点(x,y)攻击的所有点加标记，本行其他点已经右前面y=i;排除。
     * @param y 本点所在行
     * @param x 本点所在列
     */
    private void markCanAttackBy(int y,int x){
        for(int y1 = y + 1; y1 < N; y1++){
            board[y1][x]++; //  本点所在个列点
            if(x - y1 + y >= 0){ // 标识(x-1,y+1)(x-2,y+2)等.
                board[y1][x -y1 + y]++;
            }
            if(x + y1 - y < N){
                board[y1][x + y1 - y]++;
            }
        }
    }

    private void unMark(int y,int x) {
        for(int y1 = y + 1; y1 < N; y1++){
            board[y1][x]--;
            if(x -y1 + y >= 0)
                board[y1][x - y1 + y]--;
            if(x + y1 - y < N)
                board[y1][x + y1 - y]--;
        }
    }
    private void print(int n) {
        // 打印皇后布局
        System.out.println("8皇后的第" + n + "个解:");
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                System.out.print(queens[i] == j ? " Q " : " + ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        new EightQueens().putQueen(0);
    }
}
