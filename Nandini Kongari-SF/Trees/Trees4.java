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
public class Trees4 {
    TreeNode root;
    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        int h1=height(root.left);
        int h2=height(root.right);
        if(Math.abs(h1-h2)>1){
            return false;
        }
        else{
            return (isBalanced(root.left) && isBalanced(root.right)); 
        }
    }
    public int height(TreeNode root){
        if(root==null){
            return 0;
        }
        return 1+Math.max(height(root.left),height(root.right));
    }
    public static void main(String[] Args){
        Trees4 tree = new Trees4();
        tree.root = new TreeNode(3);
        tree.root.left = new TreeNode(9);
        tree.root.right = new TreeNode(20);
        //tree.root.left.left = new TreeNode(null);
        //tree.root.left.right = new TreeNode(null);
        tree.root.right.left = new TreeNode(15);
        tree.root.right.right = new TreeNode(7);
        if(tree.isBalanced(tree.root)){
            System.out.println("The tree is balanced tree");
        }
        else{
            System.out.println("The tree is not a balanced tree");
        }
    }
}
