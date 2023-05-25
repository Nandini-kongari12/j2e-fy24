import java.util.*;
public class problem5 {
    public static void rotate(int r,List<Integer> ls){
        if(r==0){return;}
        if(r>=ls.size()){
            rotate(r%ls.size(),ls);
        }
        int temp=0;
        for(int i=0;i<r;i++){
            temp=ls.remove(ls.size()-1);
            ls.add(0,temp);
        }
        return;
    }
    public static List<Integer> helper(int n){
        List<Integer> ls=new ArrayList<>();
        int i=n;
        while(i!=0){
            ls.add(0,i);
            rotate(i, ls);
            i--;
        }
        return ls;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        List<Integer> ls=helper(n);
        System.out.println(ls);
    }
}
