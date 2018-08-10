package com.istargazer.algorithm.tree;

public interface INodeProcess<T extends Node> {
    /**
     * 对节点的出来
      * @param t 节点
     */
    void doProcess(T t);
}
