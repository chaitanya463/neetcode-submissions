class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap();
        for (int i = 0; i < strs.length; i++) {
            String anagramKey = getAnagramKey(strs[i]);
            if (!map.containsKey(anagramKey)) {
                map.put(anagramKey, new ArrayList());
            }
            List<String> list = map.get(anagramKey);
            list.add(strs[i]);
            map.put(anagramKey, list);
        }
        return new ArrayList<>(map.values());
    }

    public String getAnagramKey(String value) {
        int[] charArr = new int[26];
        for (int i = 0; i < value.length(); i++) {
            charArr[value.charAt(i) - 'a']++;
        }

    return Arrays.toString(charArr);
    }
}
