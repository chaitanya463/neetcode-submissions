class Solution {
    public boolean isAnagram(String s, String t) {
        int[] count = new int[26];
        for(char character : s.toCharArray()) {
            count[character - 'a'] = ++count[character - 'a'];
        }
        for (char character : t.toCharArray()) {
            count[character - 'a'] = --count[character - 'a'];
        }

        for (int i : count) {
            System.out.println(" i = " + i);
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
