class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] s1Count = new int[26];
        int[] windowCount = new int[26];

        for (char ch : s1.toCharArray()) {
            s1Count[ch - 'a']++;
        }

        int windowSize = s1.length();
        for (int i = 0; i < s2.length(); i++) {
            windowCount[s2.charAt(i) - 'a']++;

            if (i >= windowSize) {
                windowCount[s2.charAt(i - windowSize) - 'a']--;
            }
            if (Arrays.equals(s1Count, windowCount)) {
                return true;
            }
        }
        return false;
    }
}
