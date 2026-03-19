class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> dq = new LinkedList<Integer>();
        List<Integer> answer = new ArrayList<>();
        dq.offer(0);
        for(int i = 1; i < k; i++){
           while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]){
            dq.removeLast();
           }
           dq.offerLast(i);
        }
         answer.add(nums[dq.peek()]);
        

        for(int j = k; j < n; j++){
            int startingPoint = j - k + 1;
            while(dq.size() > 0 && dq.peek() < startingPoint){
                dq.removeFirst();
            }
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[j]){
            dq.removeLast();
        }
         dq.offerLast(j);
         answer.add(nums[dq.peek()]);
        }
          
    
   
        int[] array = new int [answer.size()];
     for(int i = 0; i < answer.size(); i++){
        array[i] = answer.get(i);
     }
     return array;
}
}