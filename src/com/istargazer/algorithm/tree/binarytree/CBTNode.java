package com.istargazer.algorithm.tree.binarytree;

import com.istargazer.algorithm.tree.Node;

public class CBTNode<T extends Comparable<T>>  extends Node {
    private CBTNode parent; // 父节点引用
    private CBTNode leftChild; // 左子节点引用
    private CBTNode rightChild; // 右子节点引用

    public CBTNode(T data) {
        super.setData(data);
    }

    public CBTNode getParent() {
        return parent;
    }

    public void setParent(CBTNode parent) {
        this.parent = parent;
    }

    public CBTNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(CBTNode leftChild) {
        this.leftChild = leftChild;
    }

    public CBTNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(CBTNode rightChild) {
        this.rightChild = rightChild;
    }

}
