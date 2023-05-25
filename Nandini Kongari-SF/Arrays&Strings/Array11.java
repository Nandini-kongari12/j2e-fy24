import java.util.*;

public class Array11 {
    public static int getPeek(int n,int[] arr){
        int i=0;
        int j=1;
        int k=2;
        while(k<n){
            if(arr[j]>arr[i] && arr[j]>arr[k]){
                return j;
            }
            i++;
            j++;
            k++;
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println(getPeek(n, arr));
    }
}
