//package Trees;
import java.util.*;
public class Trees9 {
    class TreeNode {
        int val;
        TreeNode left, right;
        public TreeNode(int k)
        {
            val = k;
            left = right = null;
        }
    }
    TreeNode root;
    Trees9() { root = null; }
    Trees9(int value) { root = new TreeNode(value); }
    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null || root.val==val) return root;
        else if(root.val>val) return searchBST(root.left,val);
        else return searchBST(root.right,val);
    }
    void search(int val){
        root=searchBST(root,val);
    }
    void traverse(){
        levelOrder(root);
    }
    void levelOrder(TreeNode root){
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
                  //System.out.print("null ");
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
    void insert(int key) { root = insertRec(root, key); }
    TreeNode insertRec(TreeNode right, int key)
    {   if (right == null) {
            right = new TreeNode(key);
            return right;
        }
        if (key < right.val)
            right.left = insertRec(right.left, key);
        else if (key > right.val)
            right.right = insertRec(right.right, key);

        return right;
    }
    public static void main(String[] Args)
    {
        try (Scanner sc = new Scanner(System.in)) {
            Trees9 tree = new Trees9();
            int n=sc.nextInt();
            for(int i=0;i<n;i++){
                tree.insert(sc.nextInt());            
            }
            int k=sc.nextInt();
            tree.search(k);
            tree.traverse();
        }
    }
}
