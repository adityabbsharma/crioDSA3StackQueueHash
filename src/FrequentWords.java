/*
* K MOST FREQUENT WORDS
* Problem Description
You are given a list of words present in a book. Your younger brother is really curious to know the K most frequent words in the book, you have to find them.


Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order should come first.

Input format
There are three lines of input

The first line contains N, which is the number of input strings.

The second line contains N space separated input strings (S).

The third line contains the value of K.

Output format
Print the K most frequent words present inside the book, each in a new line. If two words have the same frequency, then the word with the lower alphabetical order should come first.

Constraints
1 <= N <= 1000

1 <= Length(S) <= 100000

'a' <= S[i] <= 'z'

1 <= K <= Number of Unique Strings

Sample Input 1
1

bus

1

Sample Output 1
bus

Explanation 1
In the given input, the frequency of "bus" is 1 and it is the 1st most frequent word.

Sample Input 2
3

car bus car

2

Sample Output 2
car

bus

Explanation 2
In the given input, the frequency of "car" is 2, frequency of “bus” is 1.

Since K = 2, both words are printed, with "car" being the most frequent, gets printed first.
* */
import java.util.*;

class FrequentWords{
    public static Vector<String> frequentWords(Vector<String> vec,int k)
    {
        HashMap<String,Integer> hMap1 = new HashMap<>();
        for(String string:vec){
            if(hMap1.containsKey(string)){
                int freq = hMap1.get(string);
                hMap1.put(string,freq+1);
            }
            else
                hMap1.put(string,1);
        }
//        List<Map.Entry<String,Integer>> sortedList = new ArrayList<>(hMap1.entrySet());
//        Collections.sort(sortedList, new Comparator<Map.Entry<String, Integer>>() {
//            @Override
//            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
//                if(o1.getValue()!=o2.getValue())
//                    return o2.getValue()-o1.getValue();
//                else{
//                    return o1.getKey().compareTo(o2.getKey());
//                }
//            }
//        });
//        Vector<String> vector = new Vector<>();
//        int i=0;
//        while(k>0){
//            vector.add(sortedList.get(i).getKey());
//            i++;
//            k--;
//        }
//        return vector;
        //-----------------------------------------

        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(hMap1.get(o1)!=hMap1.get(o2))
                    return hMap1.get(o2)-hMap1.get(o1);
                else
                    return o1.compareTo(o2);
            }
        });
        for(Map.Entry<String,Integer> mapEntrySet:hMap1.entrySet()){
            pq.add(mapEntrySet.getKey());
        }
        Vector<String> vector = new Vector<>();
        while(k>0){
            vector.add(pq.poll());
            k--;
        }
        return vector;

    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Vector<String> vec=new Vector<String>();
        for(int i=0;i<n;i++)
            vec.add(sc.next());
        int k=sc.nextInt();
        Vector<String> ans = frequentWords(vec, k);
        for(int i=0;i<k;i++)
            System.out.println(ans.get(i));
    }
}
