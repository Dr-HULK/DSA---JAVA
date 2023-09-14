import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 3, 12, 1, 5, 5, 3, 9};
        int N = arr.length;

        // Finding the maximum element of the array arr[].
        int M = 0;
        for (int i = 0; i < N; i++)
            M = Math.max(M, arr[i]);

        // Initializing Aux[] with 0
        int[] aux = new int[M + 1];
        Arrays.fill(aux, 0);

        // Mapping each element of arr[] as an index of aux[] array
        for (int i = 0; i < N; i++)
            aux[arr[i]]++;

        // Calculating prefix sum at every index of array aux[]
        int[] sortedArr = new int[N];
        for (int i = N - 1; i >= 0; i--) {
            int value = arr[i];  // Get the value from the original array
            int position = aux[value];  // Get the position from the aux array
            sortedArr[position - 1] = value;  // Place the value in sortedArr at the correct position
            aux[value]--;  // Decrement the count in the aux array
        }

        // Creating sortedArr[] from aux[] array
        int[] sortedArr = new int[N];
        for (int i = N - 1; i >= 0; i--) {
            sortedArr[aux[arr[i]] - 1] = arr[i];
            aux[arr[i]]--;
        }

        // Printing the sorted array
        for (int i = 0; i < N; i++)
            System.out.print(sortedArr[i] + " ");
    }
}
