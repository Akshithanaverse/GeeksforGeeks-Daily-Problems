// https://www.geeksforgeeks.org/problems/maximum-of-all-subarrays-of-size-k3101/1
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
