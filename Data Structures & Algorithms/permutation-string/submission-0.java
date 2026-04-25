class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] s1Count = new int[26];
        int[] window = new int[26];

        for (char c : s1.toCharArray()) {
            s1Count[c - 'a']++;
        }

        int l = 0;
        for (int r = 0; r < s2.length(); r++) {
            window[s2.charAt(r) - 'a']++;

            if (r - l + 1 > s1.length()) {
                window[s2.charAt(l) - 'a']--;
                l++;
            }

            if (Arrays.equals(s1Count, window)) {
                return true;
            }
        }

        return false;
    }
}