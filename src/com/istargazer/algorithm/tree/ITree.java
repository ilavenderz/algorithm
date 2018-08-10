package com.istargazer.algorithm.tree;

public interface ITree<N> {
    /**
     * 创建树
     * @param value
     * @return
     */
    <T extends Comparable<T>> boolean create(T value);
    /**
     * 查找节点
     * @param key
     * @return
     */
    <T extends Comparable<T>> N find(T key);

    /**
     * 插入节点
     * @param value
     * @return
     */
    <T extends Comparable<T>> boolean insert(T value);

    /**
     * 删除节点
     * @param value
     * @return
     */
    <T extends Comparable<T>> boolean delete(T value);

    /**
     * 查找最小值
     * @return
     */
    N findMini();

    /**
     * 查找最大值
     * @return
     */
    N findMax();
}
