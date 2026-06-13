class Solution {
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            // formula
            int complement = target - nums[i];

            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == complement) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{}; 
    }
}

   