import java.util.Scanner;

public class problem9 {
    public static int getHammingDistance(int a,int b){
        int res=a^b;
        int count=0;
        while(res!=0){
            count+=res&1;
            res=res>>1;
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        System.out.println(getHammingDistance(a, b));
    }
}
