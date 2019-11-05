package AssignmentSeven;

import java.util.List;
import java.util.Random;

public class Q4 {
    //Write a program that calculate the sum value in an array of ints using 4 threads.
    // You should construct an 4,000,000 long array of random numbers and return the sum of the array.
    // Please finish those two method: generateRandomArray and sum.

    public static class SumValue {

        /*generate array of random numbers*/
        static void generateRandomArray(int[] arr) {
            Random random = new Random();
            //get the next random integer value
            for (int i = 0; i < arr.length; i++) {
                arr[i] = random.nextInt();
            }
        }

        static long sum1;
        static long sum2;
        static long sum3;
        static long sum4;
        
        /*get sum of an array using 4 threads*/
        static long sum(int[] arr) {

            Thread thread1 = new Thread() {
                public void run() {
                    sum1 = sumVal(arr, 0, arr.length / 4);
                }
            };

            Thread thread2 = new Thread() {
                public void run() {
                    sum2 = sumVal(arr, arr.length / 4, arr.length / 2);
                }
            };

            Thread thread3 = new Thread() {
                public void run() {
                    sum3 = sumVal(arr, arr.length / 2, arr.length / 4 * 3);
                }
            };
            Thread thread4 = new Thread() {
                public void run() {
                    sum4 = sumVal(arr, arr.length / 4 * 3, arr.length);
                }
            };

            thread1.start();
            thread2.start();
            thread3.start();
            thread4.start();

            return sum1 + sum2 + sum3 + sum4;
        }

        public static long sumVal(int[] arr, int start, int end) {
            long res = 0;
            for (int i = start; i < end; i++)
                res += arr[i];
            return res;
        }

        public static void main(String[] args) {
            int[] arr = new int[4000000];
            generateRandomArray(arr);
            long sum = sum(arr);
            System.out.println("Sum: " + sum);
        }
    }
        public static void main(String[] args) throws IOException {
        SumValue ans = new SumValue();
        ans.main(args);
    }
}
