//package Trees;

import java.util.*;
class TreeNode {
    int val;
    TreeNode left, right;
 
    TreeNode(int k)
    {
        val=k;
        left = right = null;
    }
}
public class Trees3{
    TreeNode root;
    void invert(){
        root=invertTree(root);
    }
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return null;
        else{
            TreeNode temp=root.left;
            root.left=root.right;
            root.right=temp;
            root.left=invertTree(root.left);
            root.right=invertTree(root.right);
            return root;
        }
    }
    void levelOrder(){
        print(root);
    }
    void print(TreeNode root){
        if (root == null)
          return;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) { 
            TreeNode curr = q.poll();
              if (curr == null) {
                if (!q.isEmpty()) {
                  q.add(null);
                }
              } 
              else {
                if (curr.left != null)
                  q.add(curr.left);
                if (curr.right != null)
                  q.add(curr.right);
                System.out.print(curr.val + " ");
              }
            }
    }
    public static void main(String[] args)
    {
        Trees3 tree = new Trees3();
        tree.root = new TreeNode(4);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(7);
        tree.root.left.left = new TreeNode(1);
        tree.root.left.right = new TreeNode(3);
        tree.root.right.left = new TreeNode(6);
        tree.root.right.right = new TreeNode(9);
        tree.invert();
        tree.levelOrder();
    }
}

