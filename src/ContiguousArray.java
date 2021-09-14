/*
* Max Length contiguous array
* Problem Description
Given an array consisting of only 0s and 1s(called binary array), find the maximum length of a
* contiguous subarray with equal numbers of 0 and 1.

Input format
There are 2 lines of input

First line contains a single integer n- the number of elements in the array.

Second line contains n space separated integers- the elements of the array.

Output format
Print the length of the maximum subarray with equal numbers of 0 and 1.

Sample Input 1
7 0 0 0 1 1 0 0

Sample Output 1
4

Explanation
The subarray {0,0,1,1} has 2 0's and 2 1's. There are other subarrays also with length 4.

Constraints
1 <= n <= 10^5 0 <= a[i] <= 1
* */
import java.util.*;

class ContiguousArray {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int result = contiguousArray(n, arr);
        System.out.println(result);
    }

    static int contiguousArray(int n, int arr[]) {
//        HashMap<Integer,Integer> hMapZero = new HashMap<>();
//        HashMap<Integer,Integer> hMapOnes = new HashMap<>();
//        boolean flagThatShowsPrevZero,flagThatShowsPrevOne,flagContiguous=false,breakFlag,sequenceStart,prevZero=false,prevOne=false;
//        PriorityQueue<Integer> sequenceCounts = new PriorityQueue<>(Collections.reverseOrder());
//        int countZero=0,countOne =0,prevCountZero=0,prevCountOnes=0;
//        for(int i=0;i<n;i++){
//            if(i>0){
//                if((arr[i]==0 && arr[i-1]==1)()()())
//            }
//            if(arr[i]==0 && prevZero){
//                if(hMapZero.containsKey(0)){
//                    int freqOfZeros = hMapZero.get(0);
//                    hMapZero.put(0,freqOfZeros+1);
//                }
//            }
//            if(arr[i]==1 && prevOne){
//                if(hMapOnes.containsKey(1)){
//                    int freqOfOnes = hMapOnes.get(1);
//                    hMapOnes.put(1,freqOfOnes+1);
//                }
//            }
//            if(arr[i]==0 && i==0){
//                hMapZero.put(0,1);
//                prevZero = true;
//                prevOne = false;
//            }
//            else if(i>0){
//                if(arr[i]==0 && arr[i-1]!=0){
//                    hMapZero.put(0,1);
//                    prevZero = true;
//                    prevOne = false;
//                }
//
//            }
//            if(arr[i]==1 && i==0){
//                hMapZero.put(1,1);
//                prevOne = true;
//                prevZero = false;
//            }
//            else if(i>0){
//                if(arr[i]==1 && arr[i-1]!=1){
//                    hMapZero.put(1,1);
//                    prevOne = true;
//                    prevZero = false;
//                }
//            }
//            //-----------
////            if(arr[i]!=0 || arr[i]!=1){
////                breakFlag = true;
////                hMapOnes.put(1,0);
////                hMapZero.put(0,0);
////            }
////            if(i>0){
////                if((arr[i]==0 && arr[i-1]==1)||(arr[i]==1 && arr[i-1]==0))
////                    flagContiguous = true;
////            }
////            if(i==0 || flagContiguous){
////
////            }
//            System.out.println("arr[i]="+arr[i]+"at i="+i);
            //----------------------------------------------------------------------------------------
//            if(arr[i]==0 || arr[i]==1){
//                if(arr[i]==0){
//                    int j=i+1;
//                    countZero++;
//                    while(j<n){
//                        if(arr[j]!=0)
//                            break;
//                        else if(arr[j]==0){
//                            j++;
//                            countZero++;
//                        }
////                        System.out.println("j="+j+"countZero="+countZero);
//                    }
//                    i=j-1;
//                    prevCountZero = countZero;
//                    countZero=0;
//                    if(prevCountOnes==prevCountZero){
////                        System.out.println("in sequene loop");
//                        sequenceCounts.add(prevCountOnes);
//                    }
////                    if(i<n-1){
////                        if(arr[i+1]!=1)
////                            countZero=0;
////                    }
//                }
//                else{
//                    int j=i+1;
//                    countOne++;
//                    while(j<n){
//                        if(arr[j]!=1)
//                            break;
//                        else if(arr[j]==1){
//                            j++;
//                            countOne++;
//                        }
////                        System.out.println("j="+j+"countOne="+countOne);
//                    }
//                    i=j-1;
//                    prevCountOnes = countOne;
//                    countOne = 0;
//                    if(prevCountOnes==prevCountZero){
////                        System.out.println("in sequene loop");
//                        sequenceCounts.add(prevCountOnes);
//                    }
////                    if(i<n-1){
////                        if(arr[i+1]!=0)
////                            countOne=0;
////                    }
//                }
//            }
//
//        }
//        return 2*sequenceCounts.remove();
        for(int i=0;i<n;i++){
            if(arr[i]==0)
                arr[i] = -1;
        }
        HashMap<Integer,Integer> hMapOfCumulativeSumAndIndex = new HashMap<>();
        int cumSum=0;
        int maxSubArrayLength=0;
        for(int i=0;i<n;i++){
            cumSum += arr[i];
            if(cumSum==0){
                maxSubArrayLength = i+1;
            }
            if(hMapOfCumulativeSumAndIndex.containsKey(cumSum)){
                maxSubArrayLength = Math.max(maxSubArrayLength,(i-hMapOfCumulativeSumAndIndex.get(cumSum)));
            }
            else
                hMapOfCumulativeSumAndIndex.put(cumSum,i);
        }
        return maxSubArrayLength;
    }
}
