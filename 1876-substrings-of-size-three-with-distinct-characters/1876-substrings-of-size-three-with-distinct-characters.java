class Solution {
    public int countGoodSubstrings(String s) {
        int i = 0;
        int j = 0;
        int count = 0;
        while(j < s.length()){
            if(j - i + 1 < 3){
                j++;
            }else if(j - i + 1 == 3){
                char a = s.charAt(i);
                char b = s.charAt(i + 1);
                char c = s.charAt(j);

                if(a != b && b != c && a != c){
                    count++;
                }
                i++;
                j++;
            }
        }
        return count;
    }
}