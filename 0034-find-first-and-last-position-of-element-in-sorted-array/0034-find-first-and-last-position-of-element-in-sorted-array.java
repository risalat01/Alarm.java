class Solution {
    public int[] searchRange(int[] nums, int target) {
        int leftPosition = leftPosition(nums,target);
        int rightPosition = rightPosition(nums, target);
        int[] answer = new int[2];
        answer[0] = leftPosition;
        answer[1] = rightPosition;
        return answer;
    }
    public static int leftPosition(int[] nums, int target){
       int start = 0, end = nums.length - 1, ans = -1;
             while(start <= end){
                   int mid = (start + end)/2;
                   if(nums[mid] < target){
                    
                    start = mid + 1;
                   }else if(nums[mid] > target){
                    
                    end = mid - 1;
                   }else{
                    ans  = mid;
                    end = mid - 1;
                   }
             }
             return ans;
           }


    public static int rightPosition(int[] nums, int target){
int start = 0, end = nums.length - 1, ans = -1;
             while(start <= end){
                   int mid = (start + end)/2;
                   if(nums[mid] < target){
                    
                    start = mid + 1;
                   }else if(nums[mid] > target){
                    
                    end = mid - 1;
                   }else{
                    ans  = mid;
                    start = mid + 1;
                   }
             }
             return ans;
    }
}