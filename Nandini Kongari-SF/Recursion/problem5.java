import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class problem5 {
    public List<TreeNode> generateTrees(int n) {
        if (n % 2 == 0) {
            return new ArrayList<>();
        }
        return generateTreesHelper(n);
    }

    private List<TreeNode> generateTreesHelper(int n) {
        List<TreeNode> result = new ArrayList<>();

        if (n == 1) {
            result.add(new TreeNode(0));
            return result;
        }

        for (int i = 1; i < n; i += 2) {
            List<TreeNode> leftSubtrees = generateTreesHelper(i);
            List<TreeNode> rightSubtrees = generateTreesHelper(n - i - 1);

            for (TreeNode left : leftSubtrees) {
                for (TreeNode right : rightSubtrees) {
                    TreeNode root = new TreeNode(0);
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        problem5 solution = new problem5();
        List<TreeNode> trees = solution.generateTrees(n);
        List<List<String>> res=new LinkedList<>();
        // Print the generated trees
        for (TreeNode tree : trees) {
            List<String> ls=new LinkedList<>();
            printTree(tree,ls);
            res.add(ls);
        }
        System.out.println(res);
    }

    private static void printTree(TreeNode root,List<String> ls) {
        if (root == null) {
            return;
        }
        ls.add(root.val+"");
        if(root.left==null && root.right==null){
            return;
        }
        if(root.left!=null)
            printTree(root.left,ls);
        else
            ls.add("null");
        if(root.right!=null)
            printTree(root.right,ls);
        else
            ls.add("null");
    }
}
