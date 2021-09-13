/*
* COUNT DISTINCT ELEMENTS IN WINDOW
* Problem Description
Given an array of N elements and an integer B, you have to find the count of distinct numbers
* in all windows of size B.

You have to return an array of size N-B+1 where i'th element in the array is the number of distinct
* elements in sequence Ai, Ai+1 ,..., Ai+B-1. If B > N, return an empty array.

Input format
There are 2 lines of input

First line contains two space separated integers N and B.

Second line contains N space separated integers representing the array A.

Output format
Return the array space separated in the first line.

Function definition
You have to implement the given function. It accepts three arguments - n, b and the input array.
* You have to return the new array as described.

Sample Input 1
6 3

1 2 1 3 4 3

Sample Output 1
2 3 3 2

Explanation
First range will be [1,2,1] , in which number of distinct elements are 2

Second range will be [2,1,3], in which number of distinct elements are 3

Third range will be [1,3,4], in which number of distinct elements are 3

Fourth range will be [3,4,3], in which number of distinct elements are 2

Constraints
1<=N<=100000

1<=B<=100000

1<=Ai<=10000
*
* */
import java.util.*;

class CountDistinctElements {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int b = sc.nextInt();

        int arr[] = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        ArrayList<Integer> res = countDistinctElements(n, b, arr);

        for (int j : res)
            System.out.print(j + " ");

    }

    static ArrayList<Integer> countDistinctElements(int N, int B, int arr[]) {
        ArrayList<Integer> list = new ArrayList<>();
        if(B>N)
            return list;
//        HashSet<Integer> hSet = new HashSet<>();
        HashMap<Integer,Integer> hMap = new HashMap<>();
//        for(int i=0;i<=N-B;i++){
//            for(int j=0;j<B;j++){
//                hSet.add(arr[i+j]);
//            }
//            list.add(hSet.size());
//            hSet.clear();
//        }
//        return list;
        for(int i=0;i<B;i++){
            if(hMap.containsKey(arr[i])){
                int freq = hMap.get(arr[i]);
                hMap.put(arr[i],freq+1);
            }
            else
                hMap.put(arr[i],1);
        }
        list.add(hMap.size());
        for(int i=B;i<N;i++){
            if(hMap.containsKey(arr[i-B])){
                int freqOfArriminusB = hMap.get(arr[i-B]);
                if(freqOfArriminusB==1)
                    hMap.remove(arr[i-B]);
                else
                    hMap.put(arr[i-B],--freqOfArriminusB);
            }
            if(hMap.containsKey(arr[i])){
                int freqOfArri = hMap.get(arr[i]);
                hMap.put(arr[i],++freqOfArri);
            }
            else{
                hMap.put(arr[i],1);
            }
            list.add(hMap.size());

        }
        return list;
    }
}
