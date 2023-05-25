import java.util.*;

class graph2 {
    static class Element {
        int value;
        int index;

        public Element(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    static int minimumSwaps(int[] arr) {
        int n = arr.length;
        int swaps = 0;

       
        Element[] elements = new Element[n];
        for (int i = 0; i < n; i++) {
            elements[i] = new Element(arr[i], i);
        }

        
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (elements[j].value > elements[j + 1].value) {
                    swap(elements, j, j + 1);
                }
            }
        }

      
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);

        
        for (int i = 0; i < n; i++) {
            
            if (visited[i] || elements[i].index == i) {
                continue;
            }

            int cycleSize = 0;
            int j = i;

           
            while (!visited[j]) {
                visited[j] = true;
                j = elements[j].index;
                cycleSize++;
            }

       
            swaps += cycleSize - 1;
        }

        return swaps;
    }

  
    static void swap(Element[] elements, int i, int j) {
        Element temp = elements[i];
        elements[i] = elements[j];
        elements[j] = temp;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int minimumSwaps = minimumSwaps(arr);
        System.out.println("Minimum number of swaps required: " + minimumSwaps);
    }
}
