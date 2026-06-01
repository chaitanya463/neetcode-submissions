class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap();
        for (int i = 0; i<s.length(); i++) {
            Integer value = map.putIfAbsent(s.charAt(i), 1);
            if (value != null) {
                map.put(s.charAt(i), value + 1 );
            }
        }

        for (int i = 0; i<t.length(); i++) {
            if (map.containsKey(t.charAt(i))) {
                if (map.get(t.charAt(i)) == 1) {
                    map.remove(t.charAt(i));
                } else {
                    map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
                }
            } else {
                return false;
            }
        }
        return map.size() == 0;
    }
}
