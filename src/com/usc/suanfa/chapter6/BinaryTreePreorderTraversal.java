package com.usc.suanfa.chapter6;

/**
 * Created by xuqiang on 2017/12/10.
 */
public class BinaryTreePreorderTraversal {
    public static void main(String[] args) {

    }

    static class TreeNode {
        int val;
        TreeNode right;
        TreeNode left;
    }

    public static void preorder(TreeNode node){
        if(node != null){
            System.out.println(node.val);
            preorder(node.left);
            preorder(node.right);
        }
    }
}
