import java.util.*;
public class problem8{
    public static int getSingleElement(int n,int[] arr){
        int res=arr[0];
        for(int i=1;i<n;i++){
            res^=arr[i];
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println(getSingleElement(n, arr));
        sc.close();
    }
}