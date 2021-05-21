package com.binarysearchtree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PrintBinarySearchTree {
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

    private static void printLastLeaf(TreeNode node) {
        if(node == null){
            return;
        }

        if(node.left == null && node.right == null){
            System.out.print(node.val+" ");
        }

        printLastLeaf(node.left);
        printLastLeaf(node.right);
    }

    static void printLevelOrder() {
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

    public static void printReversalLevelOrder(){
        Stack<TreeNode> stack = new Stack<>();
        Queue<TreeNode> q = new LinkedList<>();

        if(root == null){
            System.out.println("Invalid");
            return;
        }

        q.add(root);

        while(!q.isEmpty()){
            TreeNode node  = q.poll();
            stack.push(node);

            if(node.right != null)
                q.add(node.right);
            if(node.left != null)
                q.add(node.left);
        }

        while(!stack.isEmpty()){
            System.out.print(stack.peek().val + " ");
            stack.pop();
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
        System.out.println("Last leaf");
        printLastLeaf(root);
        System.out.println("\nLevel Order Traversal");
        printLevelOrder();
        System.out.println("\nReverse Level Order Traversal");
        printReversalLevelOrder();
    }
}
