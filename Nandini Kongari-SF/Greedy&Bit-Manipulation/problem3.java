import java.util.*;

public class problem3 {
    public static int getMin(int n,int[] arr){
        int min=arr[0];
        for(int i=0;i<n;i++){
            if(arr[i]<min){
                min=arr[i];
            }
        }
        return min;
    }
    public static int minimumCadiesToBeEaten(int n,int[] arr){
        int min=getMin(n,arr);
        int count=0;
        for(int i=0;i<n;i++){
            count+=arr[i]-min;
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println(minimumCadiesToBeEaten(n, arr));
    }
}
