import java.util.*;

public class problem8 {
    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> partition = new ArrayList<>();
        partitionHelper(s, 0, partition, result);
        return result;
    }

    private static void partitionHelper(String s, int start, List<String> partition, List<List<String>> result) {
        if (start == s.length()) {
            result.add(new ArrayList<>(partition));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                partition.add(s.substring(start, i + 1));
                partitionHelper(s, i + 1, partition, result);
                partition.remove(partition.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s = sc.next();
        List<List<String>> partitions = partition(s);
        System.out.println(partitions);
    }
}
