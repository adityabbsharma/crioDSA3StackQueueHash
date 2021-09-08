/*
* Evaluate Reverse Polish Expression
* Problem Description
You are given a string representing an arithmetic expression in Reverse Polish Notation(RPN), also known as Postfix notation.

You have to evaluate the value of the expression and return the anwer.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Note:

Division between two integers should truncate toward zero.

The given expression is always valid. That means the expression would always evaluate to a result and there won't be any divide by zero operation.

Input format
One line containing one string S denoting the expression in Reverse Polish Notation where each element is separated by space.

Output format
One line denoting the output of the arithmetic expression.

Function definition
You have to implement the given function. It accepts one argument - an array of strings. Each of these strings represents one token - either an operand, or an operator. You have to return the final answer in integer.

Sample Input 1
2 1 + 3 *

Sample Output 1
9

Explanation 1
(2+1)*3 = 9

Constraints
1<=|S|<=100
* */
import java.util.*;


class ReversePolishNotation{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        Vector<String> vec = new Vector<String>();
        while(sc.hasNext())
            vec.add(sc.next());
        System.out.println(reversePolishNotation(vec));
    }

    static int reversePolishNotation(Vector<String> vec){
        int temp1=0,temp2 =0;
        Stack<Integer> s = new Stack<>();
        for(int i=0;i<vec.size();i++){
            if(vec.elementAt(i).length()>1){
                s.push(Integer.valueOf(vec.elementAt(i)));
            }
            else{
                switch (vec.elementAt(i).charAt(0)){
                    case '+':
                        temp1 = s.pop();
                        if(!s.isEmpty()){
                            temp2 = s.pop();
                        }
                        s.push(temp2+temp1);
                        break;
                    case '-':
                        temp1 = s.pop();
                        if(!s.isEmpty()){
                            temp2 = s.pop();
                        }
                        s.push(temp2-temp1);
                        break;
                    case '*':
                        temp1 = s.pop();
                        if(!s.isEmpty()){
                            temp2 = s.pop();
                        }
                        s.push(temp2*temp1);
                        break;
                    case '/':
                        temp1 = s.pop();
                        if(!s.isEmpty()){
                            temp2 = s.pop();
                        }
                        s.push(temp2/temp1);
                        break;
                    case '^':
                        temp1 = s.pop();
                        if(!s.isEmpty()){
                            temp2 = s.pop();
                        }
                        s.push((int)Math.pow(temp1,temp2));
                        break;
                    default:
                        s.push(Character.getNumericValue(vec.elementAt(i).charAt(0)));
                        break;
                }
            }

        }
        return s.pop();
    }
}
