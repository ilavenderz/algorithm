package com.istargazer.test.tree;

import com.istargazer.algorithm.tree.binarytree.CBTNode;
import com.istargazer.algorithm.tree.binarytree.CBinaryTree;

public class CBinaryTreeTest {
    public static void main(String[] args) {
        CBinaryTree tree = new CBinaryTree();
        tree.create(50);
        tree.insert(25);
        tree.insert(80);
        tree.insert(35);
        tree.insert(15);
        tree.insert(5);
        tree.insert(20);
        tree.insert(40);
        tree.insert(35);
        tree.insert(30);
        tree.insert(60);
        tree.insert(75);
        tree.insert(55);
        tree.infixOrder(tree.getRoot());
        System.out.println("end");
        CBTNode node55 = tree.find(55);
        System.out.println(node55.getData());
        System.out.println(node55.getParent().getData());
        System.out.println(node55.getLeftChild());
        System.out.println(node55.getRightChild());
        CBTNode node60 = tree.find(60);
        System.out.println(node60.getLeftChild() == node55);
        tree.delete(50);
        System.out.println(tree.getRoot().getData());
        tree.infixOrder(tree.getRoot());
        System.out.println("end");
        tree.insert(50);
        tree.infixOrder(tree.getRoot());
    }
}
