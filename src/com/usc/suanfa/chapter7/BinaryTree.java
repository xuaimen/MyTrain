package com.usc.suanfa.chapter7;



/**
 * Created by xuqiang on 2017/12/10.
 */
public class BinaryTree {
    public static void main(String[] args) {
        System.out.println("hello world!");
    }

    static class TreeNode {
        int val;
        TreeNode right;
        TreeNode left;
    }

    public static int maxDepth(TreeNode root){
        if(root == null){
            return 0;
        }

        int leftMaxDepth = maxDepth(root.left);
        int rightMaxDepth = maxDepth(root.right);

        return Math.max(leftMaxDepth,rightMaxDepth)+1;
    }
}
