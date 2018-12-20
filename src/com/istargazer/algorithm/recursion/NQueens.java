package com.istargazer.algorithm.recursion;

/**
 * 在国际象棋中，皇后是最强大的一枚棋子，可以吃掉与其在同一行、列和斜线的敌方棋子。比中国象棋里的车强几百倍，
 * 比她那没用的老公更是强的飞起（国王只能前后左右斜线走一格）。上图右边高大的棋子即为皇后。
 *
 * 八皇后问题是这样一个问题：将八个皇后摆在一张8*8的国际象棋棋盘上，使每个皇后都无法吃掉别的皇后，
 * 一共有多少种摆法？
 *
 *
 */
public class NQueens {

    private int size = 8; // 棋盘大小，默认为8
    private int total = 0; // 解数量
    private int[] grade = null; // 棋盘

    public NQueens(int size) {
        this.size = size;
        this.grade = new int[this.size];
    }

    public NQueens() {
        this(8);
    }

    private boolean isOK(int row) {
        for (int index = 0; index != row ; index++) {
            if((grade[row] == grade[index])
                    || (row - grade[row] == index - grade[index])
                    || (row + grade[row] == index + grade[index]))
                return false;
        }
        return true;
    }

    public void queen(int row) {
        if(row == this.size) {
            this.total++;
        } else {
            for (int col = 0; col != this.size; col++) {
                this.grade[row] = col;
                if(isOK(row))
                    queen(row + 1);
            }
        }
    }

    public static void main(String[] args) {
        NQueens queen = new NQueens();
        queen.queen(0);
        System.out.println(queen.total);
    }
}
