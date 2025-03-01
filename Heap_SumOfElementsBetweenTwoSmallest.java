import java.util.*;

public class Heap_SumOfElementsBetweenTwoSmallest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k1 = sc.nextInt();
        int k2 = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        System.out.println(Optimal1SumBetween(arr, k1, k2));
        System.out.println(Optimal2SumBetween(arr, k1, k2));
    }

    static int findKthSmallest(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for (int i : arr) {
            pq.offer(i);
            if (pq.size() > k)
                pq.poll();
        }

        return pq.peek();
    }

    static int Optimal1SumBetween(int[] arr, int k1, int k2) {
        int first = findKthSmallest(arr, k1);
        int second = findKthSmallest(arr, k2);
        int sum = 0;
        for (int i : arr) {
            if (first < i && i < second)
                sum += i;
        }
        return sum;
    }

    static int Optimal2SumBetween(int[] arr, int k1, int k2) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for (int i : arr) {
            pq.offer(i);
            if (pq.size() > k2)
                pq.poll();
        }

        pq.poll();
        int sum = 0;

        while (pq.size() > k1)
            sum += pq.poll();

        return sum;
    }
}
