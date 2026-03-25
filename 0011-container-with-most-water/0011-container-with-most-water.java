class Solution {
    public int maxArea(int[] height) {
        int left= 0, right = height.length - 1, maxSoFar = 0;

        while(left < right){

             int  width = right - left;
        int  curheight = Math.min(height[left], height[right]);

           int area = width * curheight;
           if(maxSoFar < area){
            maxSoFar = area;
           }
        if(height[right] < height[left]){
            area = width * curheight;
            right--;
        }else{
            left++;
        }
       
        }
        return maxSoFar;
    }
}