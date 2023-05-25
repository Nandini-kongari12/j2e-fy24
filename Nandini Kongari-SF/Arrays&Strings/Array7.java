import java.util.*;
class Array7{
    public static int getMaxSubArraySum(int n,int[] arr){
        int localMaxSum=0;
        int globalMaxSum=0;
        for(int i=0;i<n;i++){
            localMaxSum=Math.max(localMaxSum,localMaxSum+arr[i]);
            globalMaxSum=Math.max(globalMaxSum,localMaxSum);
        }
        return globalMaxSum;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println(getMaxSubArraySum(n, arr));
    }
}