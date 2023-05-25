import java.util.Scanner;
public class Array14 {
    public static int mostConcequtiveOnes(int n,int[] arr){
        int i=0;
        int j=0;
        int res=0;
        while(j<n){
            if(arr[j]==0){
                res=j-i;
                System.out.println(res);
                i=j+1;
                j++;
            }
            j++;
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
        System.out.println(mostConcequtiveOnes(n, arr));
    }
}
