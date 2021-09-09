/*
*Find length of longest valid parentheses substring
* Problem Description
Given a string S containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

Input format
First line contains a string - The string S.

Output format
Print the length of the longest valid substring.

Sample Input 1
()(()(())

Sample Output 1
6
(((())()(()
Explanation
The last 6 characters of the string forms the longest valid substring i.e. "()(())".

Constraints
0 <= length of string <= 10^5
*
* */
import java.util.*;


class LongestValidParentheses{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();
        int ans = longestValidParentheses(S);
        System.out.println(ans);
    }

    static int longestValidParentheses(String s){
        int maxLen = 0;
        Stack<Integer> stackIndex = new Stack<>();
        stackIndex.push(-1);
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stackIndex.push(i);
            }
            if(s.charAt(i)==')'){
                if(!stackIndex.isEmpty())
                    stackIndex.pop();
                if(!stackIndex.isEmpty())
                    maxLen = Math.max((i-stackIndex.peek()),maxLen);
                else
                    stackIndex.push(i);

            }
        }
        return maxLen;
    }
}
