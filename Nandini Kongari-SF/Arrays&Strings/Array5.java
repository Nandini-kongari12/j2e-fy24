import java.util.*;
public class Array5 {
    public static int getIndexOfTarget(int[] arr,int target,int low,int high){
        if(low>high){
            return -1;
        }
        int mid=(low+high)/2;
        if(arr[mid]==target){
            return  mid;
        }
        int temp=getIndexOfTarget(arr, target, low, mid-1);
        if(temp==-1){
            temp=getIndexOfTarget(arr, target, mid+1, high);
        }
        return temp;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int target=sc.nextInt();
        System.out.println(getIndexOfTarget(arr, target, 0, n-1));
    }
}
