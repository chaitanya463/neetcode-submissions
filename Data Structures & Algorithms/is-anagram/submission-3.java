class Solution {
    public boolean isAnagram(String s, String t) {
       if (s.length() - 1 != t.length() -1) {
        return false;
       }
       int[] resultArr = new int[26];
       for(char character : s.toCharArray()) {
         resultArr[character - 'a'] = resultArr[character - 'a'] + 1;
       }
       for(char character : t.toCharArray()) {
         resultArr[character - 'a'] = resultArr[character - 'a'] - 1;
       }

       for(int index : resultArr) {
        System.out.println("index = " + index);
        if (index > 0) {
            return false;
        }
       }
       return true;
    }
}
