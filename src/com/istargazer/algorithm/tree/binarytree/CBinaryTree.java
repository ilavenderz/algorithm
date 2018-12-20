package com.istargazer.algorithm.tree.binarytree;

import com.istargazer.algorithm.tree.INodeProcess;
import com.istargazer.algorithm.tree.ITree;

public class CBinaryTree implements ITree<CBTNode> {

    private CBTNode root;

    public CBTNode getRoot(){
        return root;
    }

    @Override
    public <T extends Comparable<T>> boolean create(T value) {
        boolean flag = false;
        if(null == root){
            root = new CBTNode(value);
            flag = true;
        }
        return flag;
    }

    @Override
    public <T extends Comparable<T>> CBTNode find(T key) {
        return recursionFind(root,key);
    }

    /**
     * 递归查找树节点
     * @param startNode 递归开始节点
     * @param key 要查找的对象
     * @param <T>
     * @return
     */
    private <T extends Comparable<T>> CBTNode recursionFind(CBTNode startNode,T key){
        if(null != startNode){
            int status = startNode.getData().compareTo(key); // compare node value
            if(0 == status)
                return startNode; // find node
            if(0 < status)
                return recursionFind(startNode.getLeftChild(),key); // goto the left child and compare again
            if(0 > status)
                return recursionFind(startNode.getRightChild(),key); // goto the right child and compare again
        }
        return null; // cannot find node
    }
    @Override
    public <T extends Comparable<T>> boolean insert(T value) {
        return recursionInsert(root,value);
    }

    /**
     * 递归查找节点添加位置
     * @param startNode
     * @param value
     * @param <T>
     * @return
     */
    private <T extends Comparable<T>> boolean recursionInsert(CBTNode startNode,T value){
        if(null != startNode){
            int status = startNode.getData().compareTo(value);
            if(0 < status){ // startNode.getData() > value
                if(null == startNode.getLeftChild()){
                    // add value to the left child
                    addLeftNode(startNode,value);
                    return true;
                }else{
                    // start from left child and try to add again
                    return recursionInsert(startNode.getLeftChild(),value);
                }
            }
            if(0 == status) // the value is exist
                return false;
            if(0 > status){ // startNode.getData() < value
                if(null == startNode.getRightChild()){
                    // add value to the right child
                    addRightNode(startNode,value);
                    return true;
                }else{
                    // start from right child and try to add again
                    return recursionInsert(startNode.getRightChild(),value);
                }
            }
        }else{ // root == null
            return create(value); // create new tree
        }
        return false;
    }

    /**
     * 添加左孩子
     * @param parentNode
     * @param value
     * @param <T>
     */
    private <T extends Comparable<T>> void addLeftNode(CBTNode parentNode,T value){
        CBTNode node = new CBTNode(value);
        node.setParent(parentNode);
        parentNode.setLeftChild(node);
    }

    /**
     * 添加右孩子
     * @param parentNode
     * @param value
     * @param <T>
     */
    private <T extends Comparable<T>> void addRightNode(CBTNode parentNode,T value){
        CBTNode node = new CBTNode(value);
        node.setParent(parentNode);
        parentNode.setRightChild(node);
    }
    @Override
    public <T extends Comparable<T>> boolean delete(T value) {
        CBTNode node = find(value); // node to delete
        if(null != node){
            CBTNode left = node.getLeftChild(); // left child
            CBTNode right = node.getRightChild(); // right child
            CBTNode parent = node.getParent(); // parent
            boolean isLeft = false; // is the left child
            if(root != node)
                isLeft = parent.getLeftChild() == node; // is the left child
            if(null == left && null == right){
                // no child
                setNode(parent,isLeft,null);
                return true;
            }else{
                // has left child
                if(null != left && null == right){
                    setNode(parent,isLeft,left);
                    return true;
                }
                // has right child
                if(null != right && null == left){
                    setNode(parent,isLeft,right);
                    return true;
                }
                // has both left and right child
                if(null != left && null != right){
                    // the replace node in the right child
                    return recursionFindReplaceNode(node,right,isLeft);
                }
            }
        }
        return false;
    }

    @Override
    public CBTNode findMini() {
        return recursionFindMini(root);
    }

    /**
     * 递归查找最小值
     * @param node
     * @return
     */
    private CBTNode recursionFindMini(CBTNode node){
        if(null != node){
            if(null != node.getLeftChild()){
                return recursionFindMini(node.getLeftChild());
            }else{
                return node;
            }
        }
        return null;
    }

    @Override
    public CBTNode findMax() {
        return recursionFindMax(root);
    }

    /**
     * 递归查找最大值
     * @param node
     * @return
     */
    private CBTNode recursionFindMax(CBTNode node){
        if(null != node){
            if(null != node.getRightChild())
                return recursionFindMax(node.getRightChild());
            return node;
        }
        return null;
    }
    /**
     * 递归查找替换被删除节点的节点
     * @param deleteNode
     * @param replaceNode
     * @param isLeft
     * @return
     */
    private boolean recursionFindReplaceNode(CBTNode deleteNode,CBTNode replaceNode,boolean isLeft){
        if(null != replaceNode.getLeftChild()){
            return recursionFindReplaceNode(deleteNode,replaceNode.getLeftChild(),isLeft);
        }else{ // find the smallest node among the nodes larger than the node to be deleted
            // get the right child
            CBTNode right = replaceNode.getRightChild();
            replaceNode.getParent().setLeftChild(right);
            if(null != right){ // let the replaceNode's right child to its parent's left child
                right.setParent(replaceNode.getParent());
            }
            // replace children
            replaceNode.setRightChild(deleteNode.getRightChild());
            replaceNode.setLeftChild(deleteNode.getLeftChild());
            // delete node
            setNode(deleteNode.getParent(),isLeft,replaceNode);
        }
        return false;
    }

    /**
     * 给指定节点设置子节点
     * @param node 当为null时为根节点
     * @param isLeft
     * @param value
     */
    private void setNode(CBTNode node,boolean isLeft,CBTNode value){
        if(null != node){
            if(isLeft){
                node.setLeftChild(value);
            }else{
                node.setRightChild(value);
            }
        }else{
            root = value;
        }
        value.setParent(node);
    }

    /**
     * 中序遍历
     * @param current
     * @param process
     */
    public void infixOrder(CBTNode current, INodeProcess<CBTNode> process){
        if(null != current){
            infixOrder(current.getLeftChild(),process);
            process.doProcess(current);
            infixOrder(current.getRightChild(),process);
        }
    }
    public void infixOrder(CBTNode current){
        infixOrder(current, new INodeProcess<CBTNode>() {
            @Override
            public void doProcess(CBTNode cbtNode) {
                System.out.print(cbtNode.getData() + " ");
            }
        });
    }

    /**
     * 前序遍历
     * @param current
     * @param process
     */
    public void preOrder(CBTNode current,INodeProcess<CBTNode> process){
        if(null != current){
            process.doProcess(current);
            preOrder(current.getLeftChild(),process);
            preOrder(current.getRightChild(),process);
        }
    }
    public void preOrder(CBTNode current){
        preOrder(current, new INodeProcess<CBTNode>() {
            @Override
            public void doProcess(CBTNode cbtNode) {
                System.out.print(cbtNode.getData() + " ");
            }
        });
    }

    /**
     * 后序遍历
     * @param current
     * @param process
     */
    public void postOrder(CBTNode current,INodeProcess<CBTNode> process){
        if(null != current){
            postOrder(current.getLeftChild(),process);
            postOrder(current.getRightChild(),process);
            process.doProcess(current);

        }
    }
    public void postOrder(CBTNode current){
        postOrder(current, new INodeProcess<CBTNode>() {
            @Override
            public void doProcess(CBTNode cbtNode) {
                System.out.print(cbtNode.getData() + " ");
            }
        });
    }
}
