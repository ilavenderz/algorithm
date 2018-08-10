package com.istargazer.algorithm.tree;

public abstract class Node<T extends Comparable<T>> {
    private T data; // 数据

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
