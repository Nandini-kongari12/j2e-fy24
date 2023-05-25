//package Trees;
import java.util.*;
public class Trees7 {
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
    Trees7() { root = null; }
 
    Trees7(int value) { root = new TreeNode(value); }
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
    int kthElement(int k){
        return kthSmallest(root,k);
    }
    static int x=0;
    public int kthSmallest(TreeNode root, int k) {
        inorder(root,k,new ArrayList<Integer>());
        return x;
    }
    static void inorder(TreeNode root,int k,List<Integer>l){
        if(root==null)return;
        inorder(root.left,k,l);
        l.add(root.val);
        if(l.size()==k) x=root.val;
        inorder(root.right,k,l);
    }
    public static void main(String[] args)
    {
        Trees7 tree = new Trees7();
        try (Scanner sc = new Scanner(System.in)) {
            int n=sc.nextInt();
            for(int i=0;i<n;i++){
                tree.insert(sc.nextInt());
            }
            int k=sc.nextInt();
            System.out.println(tree.kthElement(k));
        }

    }
}
