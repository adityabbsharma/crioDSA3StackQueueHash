import java.util.Scanner;

public class Stringmanipulation {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String cStr = scanner.next();
        StringBuffer str = new StringBuffer();
        int length = cStr.length();
        for(int i=0;i<length;i++){
            if(Character.isUpperCase(cStr.charAt(i)) && i==0){
                str.append(Character.toLowerCase(cStr.charAt(i)));
            }
            else if(Character.isUpperCase(cStr.charAt(i)) && i!=0){
                str.append(" ");
                str.append(Character.toLowerCase(cStr.charAt(i)));
            }
            else{
                str.append(cStr.charAt(i));
            }
        }
        System.out.println(str);
    }
}
