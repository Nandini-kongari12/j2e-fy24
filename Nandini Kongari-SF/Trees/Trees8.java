//package Trees;
import java.util.*;;
public class Trees8 {
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
    Trees8() { root = null; }
    Trees8(int value) { root = new TreeNode(value); }
    void sort(int[] nums){
        root=sortedArrayToBST(nums);
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return get(nums,0,nums.length-1); 
    }
    public TreeNode get(int[] nums,int l,int r){
        if(l>r){
            return null;
        }
        if(l==r){
            return new TreeNode(nums[l]);
        }
        int a=(l+(r-l)/2);
        TreeNode root=new TreeNode(nums[a]);
        root.left=get(nums,l,a-1);
        root.right=get(nums,a+1,r);
        return root;
        
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
    public static void main(String[] Args)
    {
        try (Scanner sc = new Scanner(System.in)) {
            Trees8 tree = new Trees8();
            int n=sc.nextInt();
            int[] ar=new int[n];
            for(int i=0;i<n;i++){
                ar[i]=sc.nextInt();            
            }
            tree.sort(ar);
            tree.traverse();
        }
    }
}
