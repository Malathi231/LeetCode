class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        int[] count1 = new int[26];
        int[] count2 = new int[26];

        // Count characters of s1
        for (char c : s1.toCharArray()) {
            count1[c - 'a']++;
        }

        int left = 0;

        for (int right = 0; right < s2.length(); right++) {

            // Add current character
            count2[s2.charAt(right) - 'a']++;

            // Keep window size equal to s1 length
            if (right - left + 1 > s1.length()) {
                count2[s2.charAt(left) - 'a']--;
                left++;
            }

            // Compare frequencies
            if (right - left + 1 == s1.length()
                    && java.util.Arrays.equals(count1, count2)) {
                return true;
            }
        }

        return false;
    }
}