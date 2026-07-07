class Solution {
    public boolean checkOnesSegment(String s) {
        int n = s.length()-1;
        for(int i=0; i<n; i++){
            if(s.charAt(i)=='0' && s.charAt(i+1)=='1'){
                return false;
            }
        }
        return true;
    }
}