/*
* Subarray with Zero sum
* Problem Description
Given an array of positive and negative numbers, you need to find if there is any subarray with 0 sum.

Note: A subarray of an array is a set of contiguous elements having a size of at least 1.

Input format
First line contains a single integer T denoting the number of test cases.

For each test case, an integer N will be given on one line and the next line will contain the N numbers of
* the array.

Output format
For each test case, print "Yes" if a subarray exists and "No" otherwise, on a single line.

Constraints
1 <= T <= 1000

1<= N <= 10000

Sum of N for all test cases will be <=200000

-10^5 <= Array element values <= 10^5

Sample Input 1
2

4

4 2 -2 5

3

3 2 -1

Sample Output 1
Yes

No

Explanation 1
For the first test case {2,-2} will be the subset that sums to 0.

For the second test case, there is no such subarray that can sum to 0.
* */
import java.util.*;

class SubarraySumZero{
    public static String subarraySumZero(Vector<Integer> arr)
    {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int[] prefixSum = new int[arr.size()];
        int allElementsZeroCheck=0;
        for(int i=0;i<arr.size();i++){
            if(i==0)
                prefixSum[0] = arr.get(0);
            else{
                prefixSum[i] = prefixSum[i-1] + arr.get(i);
            }
            if(prefixSum[i]==0)
                return "Yes";
            if(arr.get(i)!=0)
                allElementsZeroCheck =1;

        }
        if(allElementsZeroCheck==0){
            return "Yes";
        }

        HashSet<Integer> prefixSumSet = new HashSet<>();
        for(int i=0;i<arr.size();i++){
            if(prefixSumSet.contains(prefixSum[i]))
                return "Yes";
            else
                prefixSumSet.add(prefixSum[i]);
        }
        return "No";
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int j=0;j<t;j++)
        {
            int n=sc.nextInt();
            Vector<Integer> arr=new Vector<Integer>();
            for(int i=0;i<n;i++)
            {
                arr.add(sc.nextInt());
            }
            System.out.println(subarraySumZero(arr));
        }

    }
}
