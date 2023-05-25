import java.util.*;

public class problem5 {
    public static List<Integer> genSubArr(int n,int[] arr,String s){
        List<Integer> ls=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n-s.length();i++){
            sb.append('0');
        }
        sb.append(s);
        for(int i=0;i<n;i++){
            if(sb.charAt(i)=='1'){
                ls.add(arr[i]);
            }
        }
        return ls;
    }
    public static List<List<Integer>> genrateAllSubSets(int n,int[] arr){
        List<List<Integer>> res=new ArrayList<>();
        for(int i=0;i<Math.pow(2,n);i++){
            res.add(new ArrayList<>(genSubArr(n, arr, Integer.toString(i,2))));
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
        System.out.println(genrateAllSubSets(n, arr));
    }
}
