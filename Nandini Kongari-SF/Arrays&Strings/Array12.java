import java.util.*;

class Array12 {

    static int maximum(int a, int b) {
        return a > b ? a : b;
    }

    static int findMedianSortedArrays(int[] a, int n, int[] b, int m) {
        int min_index = 0, max_index = n, i, j;

        while (min_index <= max_index) {
            i = (min_index + max_index) / 2;
            j = ((n + m + 1) / 2) - i;
            if (i < n && j > 0 && b[j - 1] > a[i])
                min_index = i + 1;
            else if (i > 0 && j < m && b[j] < a[i - 1])
                max_index = i - 1;
            else {
                if (i == 0)
                    return b[j - 1];
                if (j == 0)
                    return a[i - 1];
                else
                    return maximum(a[i - 1], b[j - 1]);
            }
        }

        System.out.print("ERROR!!! returning\n");
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int nums1[] = new int[a];
        for (int i = 0; i < a; i++) {
            nums1[i] = sc.nextInt();
        }
        int nums2[] = new int[b];
        for (int i = 0; i < b; i++) {
            nums2[i] = sc.nextInt();
        }
        System.out.println(findMedianSortedArrays(nums1,a,nums2,b));
    }
}

