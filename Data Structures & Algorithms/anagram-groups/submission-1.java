class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> result = new HashMap();
        if (strs.length == 0) {
            return new ArrayList(result.values());
        }
        for (int i = 0; i < strs.length; i++) {
            String key = generateKey(strs[i]);
            List<String> list = result.computeIfAbsent(key, (k) -> new ArrayList());
            list.add(strs[i]);
            result.put(key, list);
        }
        return new ArrayList(result.values());
    }

    private String generateKey(String value) {
        int[] fingerPrint = new int[26];
        for (int i = 0; i < value.length(); i++) {
            fingerPrint[value.charAt(i) - 'a'] = fingerPrint[value.charAt(i) - 'a'] + 1;
        }
        return Arrays.toString(fingerPrint);
    }
}
