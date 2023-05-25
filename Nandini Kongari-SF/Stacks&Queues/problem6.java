import java.util.*;

public class problem6 {
    public static boolean isValidParathesis(String s){
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(st.isEmpty()){
                st.push(s.charAt(i));
                continue;
            }
            switch (s.charAt(i)) {
                case ')':
                    if(st.peek()=='('){
                        st.pop();
                    }else{
                        return false;
                    }
                    break;
                case ']':
                    if(st.peek()=='['){
                        st.pop();
                    }else{
                        return false;
                    }
                    break;
                case '}':
                    if(st.peek()=='{'){
                        st.pop();
                    }else{
                        return false;
                    }
                    break;
                default:
                    st.push(s.charAt(i));
                    break;
            }
        }
        return st.isEmpty();
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        System.out.println(isValidParathesis(s));
    }
}
