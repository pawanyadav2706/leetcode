class Solution {
    public int[] shuffle(int[] nums, int n) {
        int [] ans = new int[2 * n];
        int pointer = 0;

        for(int i=0; i<n; i++){
            ans[pointer] = nums[i];
            pointer++;

            ans[pointer] = nums[i + n];
            pointer++;
        }
        return ans;
    }
}