class Solution {
    public String sortString(String s) {
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        StringBuilder ans = new StringBuilder();
        while (ans.length() < s.length()) {
            // Increasing order
            for (int i = 0; i < 26; i++) {
                if (freq[i] > 0) {
                    ans.append((char)(i + 'a'));
                    freq[i]--;
                }
            }
            // Decreasing order
            for (int i = 25; i >= 0; i--) {
                if (freq[i] > 0) {
                    ans.append((char)(i + 'a'));
                    freq[i]--;
                }
            }
        }
        return ans.toString();
    }
}
