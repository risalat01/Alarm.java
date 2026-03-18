class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int sp = 0,fp = 0, ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        while(sp<n){
            addToMap(map,s.charAt(sp));
            while(fp < sp && !isValid(map)){
                deleteFromMap(map,s.charAt(fp));
                fp++;
            }
            int length = sp - fp + 1;
             ans = Math.max(ans,length);
             sp++;
        }
        return ans;
    }
    private void addToMap(Map<Character, Integer> map,char c){
        map.put(c,map.getOrDefault(c,0) + 1);
    }
    private void deleteFromMap(Map<Character, Integer> map, char c){
        map.put(c,map.get(c) - 1);
    }
    private boolean isValid(Map<Character, Integer> map){
for(char c : map.keySet()){
    if(map.get(c) > 1){
        return false;
    }
   
}
 return true;
    }
}