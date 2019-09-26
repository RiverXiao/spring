package com.oracle.stcdc.racgroup.leetcode;

import java.util.*;

/**
 * Tree节点定义
 */
public class TreeNode {

    private  int val;

    private TreeNode left;

    private TreeNode right;

    private TreeNode root;

    public TreeNode(){

    }
    public TreeNode(int val){
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }

    public TreeNode getRoot() {
        return root;
    }

    public boolean addNode(int nodeval){

        TreeNode node = new TreeNode(nodeval);
        if (root == null) {
            root = node;
            return true;
        }

        TreeNode current = root;
        while(current != null ){
            if(nodeval == current.val) return false;
            if(nodeval < current.val) {
                if (current.left == null) {
                    current.left = node;
                    return true;
                } else {
                    current = current.left;
                }
            }
            else{
                if(current.right == null){
                    current.right = node;
                    return true;
                }else {
                    current = current.right;
                }
            }
        }
        return  false;

    }

    //前序遍历
    public void preOrder(TreeNode current){
        if(current != null){
            System.out.print(current.getVal()+" ");
            preOrder(current.getLeft());
            preOrder(current.getRight());
        }
    }

    /**
     * 前序遍历 - 非递归
     * @param current
     * @return
     */
    public void preOrder1(TreeNode current){

        Stack<TreeNode> stack = new Stack<TreeNode>();


        while(current != null || !stack.isEmpty()){

            while (current != null){
                System.out.print(current.val + " ");
                stack.push(current);
                current = current.left;
            }

            if(!stack.isEmpty()){
                current = stack.pop();
                current = current.right;
            }

        }

    }

    /**
     * 前序遍历 - 迭代
     * @param current
     */
    public void preOrder2(TreeNode current){

        Stack<TreeNode> stack = new Stack<>();
        System.out.println("前序遍历 - 迭代");
        while(current != null || !stack.isEmpty()){

            if(current != null){
                stack.push(current);
                System.out.print(current.val + " ");
                current = current.left;
            }else{
                current = stack.pop();
                current = current.right;
            }


        }
    }

    //中序遍历
    public void infixOrder(TreeNode current){
        if(current != null){
            infixOrder(current.getLeft());
            System.out.print(current.getVal()+" ");
            infixOrder(current.getRight());
        }
    }

    /**
     * 中序遍历 - 非递归
     * @param current
     */
    public void infixOrder1(TreeNode current){

        Stack<TreeNode> stack = new Stack<>();
        System.out.println("中序遍历 - 迭代");
        while(current != null || !stack.isEmpty()){

            if(current != null){
                stack.push(current);
                current = current.left;
            }else{
                current = stack.pop();
                System.out.print(current.val + " ");
                current = current.right;
            }


        }
    }



    //后序遍历
    public void postOrder(TreeNode current){
        if(current != null){
            postOrder(current.getLeft());
            postOrder(current.getRight());
            System.out.print(current.getVal()+" ");
        }
    }

    /**
     * 后序遍历 - 非递归
     * @param current
     * @return
     */
    public void postOrder1(TreeNode current){

        Stack<TreeNode> tempstack = new Stack<>();

        Stack<TreeNode> rcstack = new Stack<>();

        System.out.println("后序遍历 - 非递归");

        while(current != null || !tempstack.isEmpty()){

            while(current != null) {
                tempstack.push(current);
                rcstack.push(current);

                current = current.right;

            }

            if(!tempstack.isEmpty()){
                current = tempstack.pop();
                current = current.left;
            }

        }

        while (!rcstack.isEmpty()){
            TreeNode node = rcstack.pop();
            System.out.print(node.val + " ");
        }


    }

    /**
     * 102 号问题：二叉树的层序遍历
     * @param current
     */
    public void levelOrder(TreeNode current){

        if(current == null) return;

        Queue<TreeNode> treeQ = new LinkedList<>();

        List<Integer> list = new ArrayList<>();

        System.out.println("层次遍历");
        treeQ.add(current);
        while ( !treeQ.isEmpty() ){

            current = treeQ.poll();
            list.add(current.val);

            if(current.left != null) treeQ.add(current.left);
            if(current.right != null) treeQ.add(current.right);

        }

        for(int var : list){
            System.out.print(var + " ");
        }
    }

    /**
     * 101 号问题：对称二叉树
     * @param current
     * @return
     */
    public boolean isSymmetric(TreeNode current) {

        if(current == null ) return true;

        return isEqual(current.left, current.right);
    }

    /**
     * 判断两棵树是否对称
     * @param left
     * @param right
     * @return
     */
    private boolean isEqual(TreeNode left, TreeNode right){
        if(left == null && right == null) return true;
        if(left == null || right == null) return false;

        return left.val == right.val && isEqual(left.left, right.right)
                && isEqual(left.right, right.left);
    }

    /**
     * 110 号问题：平衡二叉树
     * @param current
     * @return
     */
    private boolean isBalance = false;
    public boolean isBalanced(TreeNode current){
        if(current == null) return true;
        getDepth(current);
        return  isBalance;
    }

    public int getDepth(TreeNode current){
        if(current == null) return 0;

        int ldepth = getDepth(current.left);
        int rdepth = getDepth(current.right);
        isBalance = Math.abs(ldepth - rdepth) <= 1 ? true : false;
        return Math.max(ldepth + 1, rdepth + 1);
    }

    /**
     * 199 号问题：二叉树的右视图
     * @param current
     * @return
     */
    public List<TreeNode> rightSideView(TreeNode current){



        List<TreeNode> list = new ArrayList<>();
        if(current == null) return list;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(current);
        int size = 1;

        while(!queue.isEmpty()){

            int child = 0;
            for (int i = 0; i < size; i++) {

                TreeNode node = queue.poll();

                if(i == (size - 1) ) {
                    list.add(node);
                }

                if(node.left != null) {
                    queue.add(node.left);
                    child ++;
                }

                if(node.right != null){
                    queue.add(node.right);
                    child ++;
                }
            }

            size = child;


        }

        for(TreeNode node : list){
            System.out.print(node.val + " ");
        }
        return list;

    }

    /**
     * 199 号问题：二叉树的左视图
     * @param current
     * @return
     */
    public List<TreeNode> leftSideView(TreeNode current){



        List<TreeNode> list = new ArrayList<>();
        if(current == null) return list;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(current);
        int size = 1;

        while(!queue.isEmpty()){

            int child = 0;
            for (int i = 0; i < size; i++) {

                TreeNode node = queue.poll();

                if(i == 0 ) {
                    list.add(node);
                }

                if(node.left != null) {
                    queue.add(node.left);
                    child ++;
                }

                if(node.right != null){
                    queue.add(node.right);
                    child ++;
                }
            }

            size = child;


        }

        for(TreeNode node : list){
            System.out.print(node.val + " ");
        }
        return list;

    }
}