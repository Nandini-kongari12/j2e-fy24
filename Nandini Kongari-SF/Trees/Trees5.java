import java.util.LinkedList;
import java.util.Queue;
class TreeNode {
    int val;
    TreeNode left, right;
 
    TreeNode(int k)
    {
        val=k;
        left = right = null;
    }
}
public class Trees5 {
    TreeNode root1,root2,root3;
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return merge(root1,root2);
    }
    public TreeNode merge(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return null;
        if (t1 != null && t2 == null) return t1;
        if (t1 == null && t2 != null) return t2;

        t1.val += t2.val;

        t1.left = merge(t1.left, t2.left);
        t1.right = merge(t1.right, t2.right);

        return t1;
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
    public static void main(String[] Args){
        Trees5 tree = new Trees5();
        tree.root1 = new TreeNode(1);
        tree.root1.left = new TreeNode(3);
        tree.root1.right = new TreeNode(2);
        tree.root1.left.left = new TreeNode(5);
        //tree.root.left.right = new TreeNode(null);
        //tree.root1.right.left = new TreeNode(15);
        //tree.root1.right.right = new TreeNode(7);
        
        tree.root2 = new TreeNode(2);
        tree.root2.left = new TreeNode(1);
        tree.root2.right = new TreeNode(3);
        //tree.root.left.left = new TreeNode(null);
        tree.root2.left.right = new TreeNode(4);
        //tree.root2.right.left = new TreeNode(15);
        tree.root2.right.right = new TreeNode(7);
        tree.root3=tree.mergeTrees(tree.root1,tree.root2);
        tree.levelOrder(tree.root3);
    }
}
