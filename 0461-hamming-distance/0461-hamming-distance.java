class Solution {
    public int hammingDistance(int x, int y) {
        int Xor = x ^ y;
        int count = 0;
        while(Xor > 0){
            if((Xor % 2) == 1){
                count++;
            }
            Xor = Xor / 2;
        }
        return count;
    }
}