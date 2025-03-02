// https://www.geeksforgeeks.org/problems/maximum-of-all-subarrays-of-size-k3101/1
//Topics: Sliding Window, Arrays, Queue
// Brute force- not optimal
// class Solution {
//     public int getMax(Queue<Integer> queue){
//         PriorityQueue<Integer> pq=new PriorityQueue<>(Comparator.reverseOrder());
//         pq.addAll(queue);
//         return pq.poll();
//     }
//     public ArrayList<Integer> maxOfSubarrays(int arr[], int k) {
//         // code here
//         Queue<Integer> queue=new LinkedList<>();
//         ArrayList<Integer> list=new ArrayList<>();
//         int n=arr.length;
//         for(int i=0;i<n;i++){
//             queue.offer(arr[i]);
//             if(queue.size()==k)
//             {
//                 int max=getMax(queue);
//                 list.add(max);
//                 queue.poll();
//             }
//         }
//         return list;
//     }
// }

//Optimal approach
//{ Driver Code Starts
// Initial template for JAVA

import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        // taking input using class Scanner
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            // taking total number of elements
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;
            int k = Integer.parseInt(br.readLine());
            ArrayList<Integer> res = new Solution().maxOfSubarrays(arr, k);

            // printing the elements of the ArrayList
            for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
            System.out.println();
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


//{ Driver Code Starts
// Initial template for JAVA

import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        // taking input using class Scanner
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            // taking total number of elements
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;
            int k = Integer.parseInt(br.readLine());
            ArrayList<Integer> res = new Solution().maxOfSubarrays(arr, k);

            // printing the elements of the ArrayList
            for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
            System.out.println();
            System.out.println("~");
        }
    }
}
// } Driver Code Ends
class Solution {
    public ArrayList<Integer> maxOfSubarrays(int arr[], int k) {
        // code here
        ArrayList<Integer> list=new ArrayList<>();
        Deque<Integer> dq=new ArrayDeque<>();
        int n=arr.length;
        for(int i=0;i<n;i++)
        {
            if(!dq.isEmpty() && dq.peek()==i-k){
                dq.poll();
            }
            while(!dq.isEmpty() && arr[i]>arr[dq.peekLast()])
            {
                dq.pollLast();
            }
            dq.offer(i);
            if(i>=k-1)
            {
                list.add(arr[dq.peek()]);
            }
        }
        return list;
    }
}
