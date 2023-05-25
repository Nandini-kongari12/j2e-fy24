//package Trees;
import java.util.*;
public class Trees6 {
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
    Trees6() { root = null; }
 
    Trees6(int value) { root = new TreeNode(value); }
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
    boolean validate(){
        return isValidBST(root);
    }
    boolean isValidBST(TreeNode root) {
        ArrayList<Integer>l=new ArrayList<>();
        helper(root,l);
        for(int i=0;i<l.size()-1;i++){
            if(l.get(i)>=l.get(i+1)) return false;
        }
        return true;
    }
    static void helper(TreeNode root,ArrayList<Integer>l){
        if(root==null) return;
        helper(root.left,l);
        l.add(root.val);
        helper(root.right,l);
    }
    public static void main(String[] args)
    {
        Trees6 tree = new Trees6();
        try (Scanner sc = new Scanner(System.in)) {
            int n=sc.nextInt();
            for(int i=0;i<n;i++){
                tree.insert(sc.nextInt());
            }
        }
        if(tree.validate()){
            System.out.println("The given tree is Binary Search Tree");
        }
        else{
            System.out.println("The given tree is not a Binary Search Tree");
        }
    }
}