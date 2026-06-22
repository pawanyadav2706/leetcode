class Solution {
    public boolean isGoodArray(int[] nums) {
        int gcdvalue = nums[0];
        for(int i=1; i<nums.length; i++){
            gcdvalue = gcd(gcdvalue, nums[i]);
        }
        return gcdvalue == 1;
    }

    private int gcd(int a, int b){
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}