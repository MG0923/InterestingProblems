package com.binarysearchtree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeOperations {
    static TreeNode root;

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val){
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    private static int getMax(TreeNode node){
        if(node == null){
            return Integer.MIN_VALUE;
        }else{
            int leftMax = getMax(node.left);
            int rightMax = getMax(node.right);
            return Math.max(node.val, Math.max(leftMax, rightMax));
        }
    }

    private static int getMin(TreeNode node){
        if(node == null){
            return Integer.MAX_VALUE;
        }else{
            int leftMin = getMin(node.left);
            int rightMin = getMin(node.right);
            return Math.min(node.val, Math.min(leftMin, rightMin));
        }
    }

    private static int getSum(TreeNode node){
        if(node == null){
            return 0;
        }else{
            int leftSum = getSum(node.left);
            int rightSum = getSum(node.right);
            return node.val + leftSum + rightSum;
        }
    }

    private static int getHeight(TreeNode node){
        if(node == null){
            return 0;
        }else{
            int leftHeight = getHeight(node.left);
            int rightHeight = getHeight(node.right);
            return 1 + Math.max(leftHeight, rightHeight);
        }
    }

    private static void reverseTree(TreeNode node){
        if(node == null){
        }else{
            reverseTree(node.left);
            reverseTree(node.right);
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
    }

    static void printLevelOrder(TreeNode root) {
        if(root == null){
            System.out.println("Invalid");
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty())
        {
            TreeNode tempNode = queue.poll();
            System.out.print(tempNode.val + " ");

            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }

            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
    }


    public static void main(String[] args) {
        TreeNode n10 = new TreeNode(10);
        TreeNode n34 = new TreeNode(34);
        TreeNode n43 = new TreeNode(43);
        TreeNode n78 = new TreeNode(78);

        TreeNode n25 = new TreeNode(25, n10, n34);
        TreeNode n65 = new TreeNode(65, n43, n78);
        root = new TreeNode(50, n25, n65);
        System.out.println("Level Order Traversal");
        printLevelOrder(root);
        System.out.println();
        System.out.println("Max: "+getMax(root));
        System.out.println("Min: "+getMin(root));
        System.out.println("Sum: "+getSum(root));
        System.out.println("Height: "+getHeight(root));
        reverseTree(root);
        System.out.println();
        printLevelOrder(root);
    }
}
