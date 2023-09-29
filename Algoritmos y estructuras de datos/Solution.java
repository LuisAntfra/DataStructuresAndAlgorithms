import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int degreeOfArray(int[] arr) {
        // Complete this function
        /*This function receives an array and calculate the degree of the array and the character with this degree.*/
        /*Once the degree and the character were calculated, we obtain the minimum string with the character degree*/
        int degree=0;
        int result=0;
        HashMap <Integer,Integer> map = new HashMap<>();
        HashMap <Integer,Integer> size = new HashMap<>();
        HashMap <Integer,Integer> left = new HashMap<>();
        HashMap <Integer,Integer> right = new HashMap<>();
        // Complete this function
        for(int i=0;i<arr.length;i++)
        {
            /*If the character is not contained in the hashmap, then put into*/
            if(!map.containsKey(arr[i]))
            {
                /*Update the degree when equals to zero*/
                if(degree==0)
                {
                    degree=1;
                    size.put(arr[i],degree);
                }
                map.put(arr[i],1);
            }else
            {
                map.replace(arr[i],map.get(arr[i])+1);
                if(map.get(arr[i])>degree)
                {
                    degree=map.get(arr[i]);
                    size=null;
                    size = new HashMap<>();
                    size.put(arr[i],degree);
                }else if (map.get(arr[i])==degree)
                {
                    size.put(arr[i],degree);
                }
            }
        }
        
        /*Look for the first index for the degree character from left to right*/
        for(Integer key:size.keySet())
        {
            for(int i=0;i<arr.length;i++)
            {
                if(key==arr[i])
                {
                    left.put(key,i);
                    break;
                }
            }
        }
        
        /*Look for the first index for the degree character from right to left*/
        for(Integer key:size.keySet())
        {
            for(int i=arr.length-1;i>=0;i--)
            {
                if(key==arr[i])
                {
                    right.put(key,i);
                    break;
                }
            }
        }

        /*Calculate the lower size for an array with the same degree*/
        for(Integer key:size.keySet())
        {
            if(result==0)
            {
                result=right.get(key)-left.get(key)+1;
            }else
            {
                if(right.get(key)-left.get(key)+1<result)
                {
                    result=right.get(key)-left.get(key)+1;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        int[] arr = new int[size];
        for(int arr_i = 0; arr_i < size; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        int res = degreeOfArray(arr);
        System.out.println(res);
        in.close();
    }
}