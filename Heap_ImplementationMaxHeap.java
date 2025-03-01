import java.util.*;

public class Heap_ImplementationMaxHeap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        Max_Heap(arr);
    }

    static void Max_Heap(int[] arr){
        int n=arr.length;
        Heap_MAX maxh=new Heap_MAX();
        System.out.println("Insertion");
        for(int i=0;i<n;i++){
            maxh.insert(arr[i]);
            System.out.println(maxh.heap);
        }
        System.out.println("Deletion");
        for(int i=0;i<n;i++){
            System.out.print(maxh.delete()+"<- ");
            System.out.println(maxh.heap);
        }
    }

    static class Heap_MAX {
        ArrayList<Integer> heap;

        Heap_MAX() {
            heap = new ArrayList<>();
        }

        int parent(int index) {
            return (index - 1) / 2;
        }

        int leftChild(int index) {
            return 2 * index + 1;
        }

        int rightChild(int index) {
            return 2 * index + 2;
        }

        void swap(int a, int b) {
            int temp = heap.get(a);
            heap.set(a, heap.get(b));
            heap.set(b, temp);
        }

        void insert(int value) {
            heap.add(value);
            int currindex = heap.size() - 1;

            while (currindex > 0 && heap.get(currindex) > heap.get(parent(currindex))) {
                swap(currindex, parent(currindex));
                currindex = parent(currindex);
            }
        }

        int delete() {
            int max = heap.get(0);
            int lastelement = heap.remove(heap.size() - 1);

            if (!heap.isEmpty()) {
                heap.set(0, lastelement);
                int currindex = 0;

                while (true) {
                    int left = leftChild(currindex);
                    int right = rightChild(currindex);
                    int smallest = currindex;

                    if (left < heap.size() && heap.get(left) > heap.get(smallest))
                        smallest = left;

                    if (right < heap.size() && heap.get(right) > heap.get(smallest))
                        smallest = right;
                    
                    if(smallest==currindex)
                        break;
                    
                    swap(currindex, smallest);
                    currindex=smallest;
                }
            }

            return max;
        }
    }
}
