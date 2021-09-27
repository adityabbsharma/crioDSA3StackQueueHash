/*
* Kth largest element in array
* Problem Description
Given an unsorted array, find the Kth largest element in it.

Note: The need is to find the Kth largest element in the sorted order.

Input format
First line has the integer N, representing the number of elements in the array

Second line has N integers representing elements of the array

Third line has K, which is the Kth largest element to be found

Output format
The Kth largest element value needs to be printed

Constraints
1 <= N <= 1e5

0 <= Array Values <= 1e9

1 ≤ K ≤ N

Sample Input 1
6

3 2 1 5 6 4

2

Sample Output 1
5

Explanation 1
From the given input array, we have to find the second largest value. The first largest is 6 and the second largest is 5, which is the answer.

Sample Input 2
9

3 2 3 1 2 4 5 5 6

4

Sample Output 2
4

Explanation 2
From the given input array, we have to find the fourth largest value. The sorted order with largest first is 6 5 5 4 3 3 2 2 1. The fourth largest here has the value 4.
* */
import java.io.*;
import java.util.*;

class KthLargestElementInAnArray {

    // Implement your solution by completing the below function
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
        }
        while(k-->1){
            pq.remove();
        }
        return pq.remove();

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int nums[] = new int[n];
        for (int i = 0; i < n; ++i)
            nums[i] = scanner.nextInt();

        int k = scanner.nextInt();
        scanner.close();

        int result = new KthLargestElementInAnArray().findKthLargest(nums, k);
        System.out.println(result);
    }
}

