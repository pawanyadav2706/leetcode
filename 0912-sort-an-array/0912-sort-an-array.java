class Solution {
    public int[] sortArray(int[] nums) {
        sort(nums,0, nums.length-1);
        return nums;
    }
    static void sort(int[] nums, int low, int high){
		if(low >= high) {
			return;
		}
		int s = low;
		int e = high;
		int mid = s + (e - s) / 2;
		int pivot = nums[mid];
		 
		while(s <= e) {
			// also a reason why if its already sorted it will not swap
			while(nums[s] < pivot) {
				s++;
			}
			while(nums[e] > pivot) {
				e--;
			}
			if(s <= e) {
			int temp = nums[s];
			nums[s] = nums[e];
			nums[e] = temp;
			s++;
			e--;
			}
		}
		// now my pivot is correct please to sort half now
		sort(nums,low,e);
		sort(nums,s,high);
	}
    }
