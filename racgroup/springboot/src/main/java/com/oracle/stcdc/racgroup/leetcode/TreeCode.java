package com.oracle.stcdc.racgroup.leetcode;


public class TreeCode {


    public static void main(String[] args) {
        System.out.println("Yes");
        TreeNode tree = new TreeNode();
        System.out.println(tree.addNode(10));
        System.out.println(tree.addNode(6));
        System.out.println(tree.addNode(12));
        System.out.println(tree.addNode(3));
        System.out.println(tree.addNode(8));
        System.out.println(tree.addNode(11));
        System.out.println(tree.addNode(15));
        System.out.println(tree.addNode(9));
        System.out.println(tree.addNode(13));
        System.out.println(tree.addNode(2));

        System.out.println("前序遍历 - 循环");
        tree.preOrder1(tree.getRoot());
        System.out.println();
        tree.preOrder2(tree.getRoot());
        System.out.println();
        System.out.println("前序遍历 - 递归");
        tree.preOrder(tree.getRoot());
        System.out.println();
        System.out.println("中序遍历 - 递归");
        tree.infixOrder(tree.getRoot());
        System.out.println();
        tree.infixOrder1(tree.getRoot());
        System.out.println();
        System.out.println("后序遍历");
        tree.postOrder(tree.getRoot());
        System.out.println();
        tree.postOrder1(tree.getRoot());

        System.out.println();
        tree.levelOrder(tree.getRoot());
        System.out.println();
        System.out.println("是否对称树");
        System.out.println(tree.isSymmetric(tree.getRoot()));

        System.out.println();
        System.out.println("树的深度");
        System.out.println(tree.getDepth(tree.getRoot()));

        System.out.println();
        System.out.println("是否是平衡二叉树");
        System.out.println(tree.isBalanced(tree.getRoot()));

        System.out.println();
        System.out.println("右视图");
        tree.rightSideView(tree.getRoot());

        System.out.println();
        System.out.println("左视图");
        tree.leftSideView(tree.getRoot());

    }

}
