class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";

        int[] countT = new int[128];
        for (char c : t.toCharArray()) countT[c]++;

        int[] window = new int[128];
        int have = 0, need = 0;

        for (int i = 0; i < 128; i++) {
            if (countT[i] > 0) need++;
        }

        int l = 0, resLen = Integer.MAX_VALUE;
        int resL = 0, resR = 0;

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            window[c]++;

            if (countT[c] > 0 && window[c] == countT[c]) {
                have++;
            }

            while (have == need) {
                if ((r - l + 1) < resLen) {
                    resLen = r - l + 1;
                    resL = l;
                    resR = r;
                }

                char left = s.charAt(l);
                window[left]--;
                if (countT[left] > 0 && window[left] < countT[left]) {
                    have--;
                }
                l++;
            }
        }

        return resLen == Integer.MAX_VALUE ? "" : s.substring(resL, resR + 1);
    }
}