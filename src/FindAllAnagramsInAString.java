/*
* Find all anagrams in a string
* Problem Description
You are given two strings, a main string S, and a pattern P. You have to find the starting indices of
* the anagrams of P in S.


Anagrams are permutations of a string. For P="abc”, its anagrams are abc,acb,bca,bac,cba,cab.


Note that indexing starts at 0.

Input format
There is one line of input, containing two space-separated strings S and P.

Output format
First-line should contain the number of such starting indices.

Next line should contain the indices in increasing order separated by a space.

Sample Input 1
aaba ab

Sample Output 1
2

1 2

Explanation 1
The anagrams of pattern "ab" are “ab” and “ba”. These are present at indices 1 and 2 of the input string “aaba”.

Sample Input 2
bacdgabcda abcd

Sample Output 2
3

0 5 6

Explanation 2
The anagrams of "abcd" can be seen as “bacd” at index 0, “abcd” at index 5 and “bcda” at index 6.

Constraints
1 <= length(S), length(P) <= 10^6
* */
import java.util.*;

// Implement your solution here
class FindAllAnagramsInAString {

    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> aList = new ArrayList<>();
        HashMap<Character,Integer> hMapofP = new HashMap<>();
        for(int i=0;i<p.length();i++)
            hMapofP.put(p.charAt(i),hMapofP.getOrDefault(p.charAt(i),0)+1);
        //System.out.println(hMapofP);
        long[] pSum = new long[s.length()];
        pSum[0] = s.charAt(0);
        //System.out.println(pSum[0]);
        int lOfp= p.length();
        System.out.println("lOfP="+lOfp);
        for(int i=1;i<s.length();i++){
            pSum[i] = pSum[i-1] + s.charAt(i);
            //System.out.println("pSum[i]="+pSum[i]);
        }
        ArrayList<Integer> returnList = new ArrayList<>();
        long ascciOfp=0;
        for(int i=0;i<lOfp;i++)
            ascciOfp += p.charAt(i);
        System.out.println("ascci of p ="+ascciOfp);
        for(int i=0;i<=s.length()-p.length();i++){
            if(i>0){
                if(i==110)
                    System.out.println("at i=110 ascii of substring="+(pSum[lOfp+i-1] - pSum[i-1]));
                //System.out.println("s.substring(i,i+lOfp)="+s.substring(i,i+lOfp)+" at i="+i);
                if((pSum[lOfp+i-1] - pSum[i-1])== ascciOfp){
                    //System.out.println("s.substring(i,i+lOfp)="+s.substring(i,i+lOfp)+" at i="+i);
                    if(check(s.substring(i,i+lOfp),hMapofP))
                        returnList.add(i);
                }
            }
            else{
                //System.out.println("s.substring(i,lOfp-1)="+s.substring(i,lOfp)+" at i="+i);
                if(pSum[lOfp-1] == ascciOfp){
                    //System.out.println("s.substring(i,lOfp)="+s.substring(i,lOfp)+" at i="+i);
                    if(check(s.substring(i,lOfp),hMapofP))
                        returnList.add(i);
                }
            }

        }
        return returnList;
    }
    public boolean check(String org,HashMap<Character,Integer> hMapOfP){
        HashMap<Character,Integer> hMap = new HashMap<>();
        //System.out.println("org="+org);
        for(int i=0;i<org.length();i++)
            hMap.put(org.charAt(i),hMap.getOrDefault(org.charAt(i),0)+1);
        //System.out.println(hMap);
        for(Map.Entry<Character,Integer> map:hMap.entrySet()){
            char c = map.getKey();
            if(hMapOfP.containsKey(c)){
                if(!hMapOfP.get(c).equals(map.getValue())){
                    //System.out.println("at c= "+c+" map.getValue()= "+map.getValue()+" hMapOfP.get(c)="+hMapOfP.get(c));
                    return false;
                }

            }
            else
                return false;
        }
        return true;

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = new String[2];
        input = scanner.nextLine().split(" ");
        String s = input[0];
        String p = input[1];
        scanner.close();

        List<Integer> result = new FindAllAnagramsInAString().findAnagrams(s,p);
        System.out.println(result.size());
        for (Integer i = 0; i < result.size(); ++i) {
            System.out.printf("%d ", result.get(i));
        }
    }
}
