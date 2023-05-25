import java.util.*;

public class problem6 {
    static List<Integer> res=new LinkedList<>();
    public static void printSubsetSums(int[] arr) {
        List<Integer> subset = new ArrayList<>();
        subsetSumsHelper(arr, 0, subset, 0);
    }

    private static void subsetSumsHelper(int[] arr, int index, List<Integer> subset, int sum) {
        if (index == arr.length) {
            res.add(sum);
            return;
        }
        subsetSumsHelper(arr, index + 1, subset, sum);
        subset.add(arr[index]);
        subsetSumsHelper(arr, index + 1, subset, sum + arr[index]);
        subset.remove(subset.size() - 1);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        printSubsetSums(arr);
        Collections.sort(res);
        System.out.println(res);
    }
}
