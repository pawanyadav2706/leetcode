class Solution {
    public int[] singleNumber(int[] nums) {
        int txor = 0;
        for(int element : nums){
            txor = txor ^ element;
        }
        int mask = (txor & (txor - 1) ^ txor);
        int [] res = new int[2];
        for(int element : nums){
            if((element & mask) == 0){
                res[0]  = res[0] ^ element;
            }else{
                res[1] = res[1] ^ element;
            }
        }
        return res;
    }
}