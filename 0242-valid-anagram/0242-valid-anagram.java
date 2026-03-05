class Solution {
    public boolean isAnagram(String s, String t) {
        
        char[] Tarr = t.toCharArray();
        char[] Sarr = s.toCharArray();
        Arrays.sort(Tarr);
        Arrays.sort(Sarr);

        return Arrays.equals(Sarr,Tarr);
    }
}