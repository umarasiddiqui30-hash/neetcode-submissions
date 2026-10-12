class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> mapping = new HashMap<>();
        if (s.length() != t.length()) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (mapping.containsKey(c)) {
                int count = mapping.get(c);
                count++;
                mapping.replace(c, count);
            } else {
                mapping.put(c, 1);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (mapping.containsKey(c)) {
                int count = mapping.get(c);
                count--;
                mapping.replace(c, count);
            } else {
                return false;
            }
        }

        for (int counts : mapping.values()) {
            if (counts != 0) {
                return false;
            }
        }
        return true;
    }
}
