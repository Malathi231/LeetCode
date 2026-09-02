class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();

        if (s.length() < p.length()) {
            return result;
        }

        int[] pCount = new int[26];
        int[] windowCount = new int[26];

        // Count characters in p
        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }

        int k = p.length();

        // First window
        for (int i = 0; i < k; i++) {
            windowCount[s.charAt(i) - 'a']++;
        }

        // Check first window
        if (Arrays.equals(pCount, windowCount)) {
            result.add(0);
        }

        // Slide the window
        for (int i = k; i < s.length(); i++) {

            // Add new character
            windowCount[s.charAt(i) - 'a']++;

            // Remove old character
            windowCount[s.charAt(i - k) - 'a']--;

            // Check if anagram
            if (Arrays.equals(pCount, windowCount)) {
                result.add(i - k + 1);
            }
        }

        return result;
    }
}