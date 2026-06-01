class Solution {
    public boolean isAnagram(String s, String t) {
        char[] sCharArr = s.toCharArray();
        char[] tCharArr = t.toCharArray();
        Arrays.sort(sCharArr);
        Arrays.sort(tCharArr);
        if (sCharArr.length != tCharArr.length) {
            return false;
        }
        for (int i = 0; i < sCharArr.length ; i++) {
            if (sCharArr[i] != tCharArr[i]) {
                return false;
            }
        }
        return true;
    }
}
