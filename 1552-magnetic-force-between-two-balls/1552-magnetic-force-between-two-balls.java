class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n = position.length;
        int ans = 1;
        int start = 1, end = position[n-1] - position[0];
        while(start <= end){
            int mid = (start + end)/2;
            if(isDistancePossible(position,m,mid)){
                ans = mid;
                start = mid + 1;
            }else{
                end  = mid - 1;
            }
        }
        return ans;
    }
    private Boolean isDistancePossible(int[] position, int noOfBall, int distance){
         int ballPlaced = 1;
         int positionOfBall = position[0];
         for(int i = 0; i < position.length && ballPlaced < noOfBall; i++){
            if(position[i] >= positionOfBall + distance){
            ballPlaced++;
           positionOfBall =  position[i];
            }
         }
         return ballPlaced == noOfBall;
    }
}