//package Trees;

class TreeNode {
    int val;
    TreeNode left, right;
 
    TreeNode(int k)
    {
        val=k;
        left = right = null;
    }
}
public class Trees2 {
    TreeNode root;
    public boolean isSymmetric(TreeNode root) {
        if(check(root.left,root.right)){
            return true;
        }
        return false;
    }
    public boolean check(TreeNode a,TreeNode b){
             if(a==null && b==null){
            return true;
        }
        else if(a==null || b==null){
            return false;
            }
        else{
            if(a.val==b.val){
                return check(a.left,b.right) && check(b.left,a.right);
            }
            return false;
        }            
    }
    public static void main(String[] Args){
            Trees2 tree = new Trees2();
     
            tree.root = new TreeNode(1);
            tree.root.left = new TreeNode(2);
            tree.root.right = new TreeNode(2);
            tree.root.left.left = new TreeNode(3);
            tree.root.left.right = new TreeNode(4);
            tree.root.right.left = new TreeNode(4);
            tree.root.right.right = new TreeNode(3);
        if(tree.isSymmetric(tree.root)) {
            System.out.println("Tree is symmetrical");
        }
        else{
            System.out.println("Tree is not symmetrical");
        }
    }
}
