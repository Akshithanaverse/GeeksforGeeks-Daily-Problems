//https://www.geeksforgeeks.org/problems/decode-the-string2444/1
//Topics: Stack, Recursion,BackTracking, Data Structures, Algorithms
//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            String s = in.readLine();

            Solution ob = new Solution();
            out.println(ob.decodeString(s));

            out.println("~");
        }
        out.close();
    }
}
// } Driver Code Ends

class Solution {
    static String decodeString(String s) {
        // code here
        Stack<Character> stack=new Stack<>();
        for(char ch:s.toCharArray())
        {
            if(ch==']')
            {
                StringBuilder num=new StringBuilder("");
                StringBuilder sb=new StringBuilder("");
                while(!stack.isEmpty() && stack.peek()!='[')
                {
                    sb.insert(0,stack.pop());
                }
                stack.pop();
                while(!stack.isEmpty() && stack.peek()>='0' && stack.peek()<='9'){
                    num.insert(0,stack.pop());
                }
                int number=Integer.parseInt(num.toString());
                while(number-->0)
                {
                    for(char letter: sb.toString().toCharArray()){
                        stack.push(letter);
                    }
                }
            }
            else
            {
                stack.push(ch);
            }
        }
        StringBuilder result=new StringBuilder("");
        while(!stack.isEmpty()){
            result.insert(0,stack.pop());
        }
        return result.toString();
    }
}
