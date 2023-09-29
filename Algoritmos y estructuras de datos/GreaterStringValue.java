import java.util.Scanner;
import java.util.ArrayList;

public class GreaterStringValue{
    private static String biggerSubStr(String str){
        /*take any character in the string str and compare if it exist in the linked list, if exist, then ignore it, if not, then add it.*/
        ArrayList<Character> rigthChars = new ArrayList<Character>();
        ArrayList<Character> leftChars = new ArrayList<Character>();

        for(int i=0;i<str.length();i++)
        {
            
                if(!(rigthChars.contains(str.charAt(i))))
                {
                    rigthChars.add(str.charAt(i));
                }
            
        }

        for(int i=str.length()-1;i>-1;i--)
        {
            if(!(leftChars.contains(str.charAt(i))))
            {
                leftChars.add(str.charAt(i));
            }
        }

        if(leftChars.toString().compareTo(rigthChars.toString())>0)
        {
            return leftChars.toString();
        }else
        {
            return rigthChars.toString();
        }
    }

    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        System.out.print("Introduce una cadena de texto:");
        String string = sc.nextLine();
        String resulString=biggerSubStr(string);
            System.out.println(resulString);
        sc.close();
    }
}