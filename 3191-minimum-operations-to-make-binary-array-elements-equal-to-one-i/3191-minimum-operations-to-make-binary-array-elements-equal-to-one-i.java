class Solution {
    public int minOperations(int[] nums) {
        int count = 0;
        int n = nums.length;
        for(int i = 0; i<= n - 3; i++){
            if(nums[i] == 0){
                // xor operation perform
                nums[i]^= 1;
                nums[i + 1]^= 1;
                nums[i + 2]^= 1;
                count++;
            }
        }
        // if given array is not all emement is 1 so this condition follow
        for(int i = 0; i<n; i++){
            if(nums[i] == 0){
                return -1;
            }
        }
        return count;
    }
}