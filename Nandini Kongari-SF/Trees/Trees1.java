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
public class Trees1{
    TreeNode root1,root2;
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null){
            return true;
        }
        else if(p==null || q==null){
            return false;
        }
            else{
                return(p.val==q.val && isSameTree(p.left,q.left) &&isSameTree(p.right,q.right));
            }
        }
    public static void main(String[] Args){
        Trees1 tree = new Trees1();
 
        tree.root1 = new TreeNode(1);
        tree.root1.left = new TreeNode(2);
        tree.root1.right = new TreeNode(3);
        //tree.root1.left.left = new TreeNode(4);
        //tree.root1.left.right = new TreeNode(5);
 
        tree.root2 = new TreeNode(1);
        tree.root2.left = new TreeNode(2);
        tree.root2.right = new TreeNode(3);
        //tree.root2.left.left = new TreeNode(4);
        //tree.root2.left.right = new TreeNode(5);
        if (tree.isSameTree(tree.root1, tree.root2))
            System.out.println("Both trees are identical");
        else
            System.out.println("Trees are not identical");
    }
}
