import java.util.*;

public class Array15 {
    public static int getKthLargestInArray(int n,int[] arr,int k){
        if(k>n){
            return Integer.MIN_VALUE;
        }
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<n;i++){
            pq.add(arr[i]);
        }
        int count=0;
        while(count<k-1){
            pq.remove();
            count++;
        }
        return pq.peek();
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int k=sc.nextInt();
        System.out.println(getKthLargestInArray(n, arr, k));
    }
}
