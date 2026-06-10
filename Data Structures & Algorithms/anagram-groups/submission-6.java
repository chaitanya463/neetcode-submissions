class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String , List<String>> map = new HashMap();
        for (int i = 0; i < strs.length; i++) 
        {
            String key = generateKey(strs[i]);
            List<String> valueArr = map.getOrDefault(key, new ArrayList());
            valueArr.add(strs[i]);
            map.put(key, valueArr);
        }
        return new ArrayList(map.values());
    }

    public String generateKey(String token) {
        int[] fingerPrint = new int[26];
        for (int i = 0; i < token.length(); i++) {
            fingerPrint[token.charAt(i) - 'a'] = fingerPrint[token.charAt(i) - 'a'] + 1;
        }
        System.out.println("token " + token + " finger = " + Arrays.toString(fingerPrint));
        return Arrays.toString(fingerPrint);
    }
}
