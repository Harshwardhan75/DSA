import java.util.*;

public class Heap_ImplementationMinHeap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        Min_Heap(arr);
    }

    static void Min_Heap(int[] arr){
        int n=arr.length;
        Heap_MIN minh=new Heap_MIN();
        System.out.println("Insertion");
        for(int i=0;i<n;i++){
            minh.insert(arr[i]);
            System.out.println(minh.heap);
        }
        System.out.println("Deletion");
        for(int i=0;i<n;i++){
            System.out.print(minh.delete()+"<- ");
            System.out.println(minh.heap);
        }
    }

    static class Heap_MIN {
        ArrayList<Integer> heap;

        Heap_MIN() {
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

            while (currindex > 0 && heap.get(currindex) < heap.get(parent(currindex))) {
                swap(currindex, parent(currindex));
                currindex = parent(currindex);
            }
        }

        int delete() {
            int min = heap.get(0);
            int lastelement = heap.remove(heap.size() - 1);

            if (!heap.isEmpty()) {
                heap.set(0, lastelement);
                int currindex = 0;

                while (true) {
                    int left = leftChild(currindex);
                    int right = rightChild(currindex);
                    int smallest = currindex;

                    if (left < heap.size() && heap.get(left) < heap.get(smallest))
                        smallest = left;

                    if (right < heap.size() && heap.get(right) < heap.get(smallest))
                        smallest = right;
                    
                    if(smallest==currindex)
                        break;
                    
                    swap(currindex, smallest);
                    currindex=smallest;
                }
            }

            return min;
        }
    }
}
