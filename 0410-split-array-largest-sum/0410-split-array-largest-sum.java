class Solution {
    public int splitArray(int[] nums, int k) {
            int start = 0;
	        int end = 0;
	        
	        for(int i= 0; i< nums.length; i++) {
	        	start = Math.max(start, nums[i]); //in the code of the loop this will be the contain d the max item  from the array
	        	end = end +nums[i];
	        }
	        // binary search 
	        while(start<end) {
	        	int mid = start + (end - start) / 2;
	        	// calculate how many pieces you can divided in this with max sum
	        	
	        	int sum = 0;
	        	int pieces = 1;
	        	for(int num: nums) {
	        		if(sum + num > mid) {
	        			// you cannot add this in this subarray,make new one  
	        			sum = num;
	        			pieces++;
	        		}else {
	        			sum = sum+num;
	        		}
	        	}
	        	if(pieces > k) {
	        		start = mid+1;
	        	}else {
	        		end = mid;
	        	}
	        	
	        }
	        return end; // here start == end
    }
}