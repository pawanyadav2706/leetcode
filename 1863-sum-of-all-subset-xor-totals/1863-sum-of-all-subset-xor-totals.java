class Solution {
    public int subsetXORSum(int[] nums) {
        return solve(nums, 0, 0);
    }
    public int solve(int[] nums,int index, int xor){
        // this is base case
        if(index == nums.length){
            return xor;
        }
        // include 
        int include = solve(nums, index + 1, xor ^ nums[index]);
        // exclude
        int exclude = solve(nums, index + 1, xor);

        return include + exclude;

    }
}