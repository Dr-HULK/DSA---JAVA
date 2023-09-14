import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void countSort(int[] arr, int min, int max){
        int range = max - min + 1;

        //Created the new array with the range of input array
        //Frequency array
        int[] freq = new int[range];

        //Adding the frequency of each unique element here
        for(int i=0; i < arr.length; i++){
             int index = arr[i] - min;
             freq[index]++;
        }

        //After this - each element will have the frequency allocated with their respective position.
        //Now we will convert the frequency array into prefix sum, which will help us in placing the elements to its appropriate place in the final array
        //Creating the prefix sum
        // It is calculated by summation of previous numbers till that number
        for(int i =1; i < freq.length; i++){
            freq[i] = freq[i] + freq[i -1];
        }
        // We now have the Prefix sum of the array
        // What prefix sum indicates that which elements will be at last in which index of the final array
        //6[9] = 15, it means that element 9 present in the original array will be at max at 15 position

        //Create an array which is of same size as the input array
        //Run loop from the last element till the 1st and fill the array accordingly
        //Find the value first from the input array
        //find out the position in the frequency array
        //Find the index in final array
        //Put the element in index inside final array and decrement the value in the frequency array of that element

        int[] finalArray = new int[arr.length];
        for(int i = arr.length -1; i >=0 ; i-- ){
            int value = arr[i];
            int position = freq[value - min];
            int index = position -1;
            finalArray[index] = value;
            freq[value-min]--;
        }

        for(int i=0 ; i< arr.length; i++){
            arr[i] = finalArray[i];
        }
    }

    public static void print(int[] arr) {
        for(int i =0; i< arr.length; i++){
            System.out.println(arr[i]);
        }
    }
    public static void main(String[] args) {
        int[] arr = new int[]{4,3,2,5,4,3,5,1,0,2,5};
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int num : arr){
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        countSort(arr, min, max);
        print(arr);
    }
}