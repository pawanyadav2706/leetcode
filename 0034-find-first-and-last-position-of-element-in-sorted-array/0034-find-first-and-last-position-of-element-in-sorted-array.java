class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = findIndex(nums, target, true);
        int last = findIndex(nums, target, false);
        return new int[]{first, last};
    }
    
    private int findIndex(int[] nums, int target, boolean findFirst) {
        int s = 0;
        int e = nums.length - 1;
        int ans = -1;
        
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (nums[mid] == target) {
                ans = mid;
                if (findFirst) {
                    e = mid - 1; 
                } else {
                    s = mid + 1; 
                }
            } else if (nums[mid] > target) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        
        return ans;
    }
}
