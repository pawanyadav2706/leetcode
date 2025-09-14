class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        	int start = 0;
		int end = arr.length-1;
		while(start<end) {
			int mid= start + (end-start) /2; 
			
			if(arr[mid] > arr[mid+1]) {
				// you are decreasing part of the array
				// this may be the ans but look at left
				// this is why end != mid -1 
				end = mid;
			} else{
				// you are increasing part of the array
				start = mid+1;  // beacuse we know that mid+1 element > mid element 
			} 
			}
			// in the end, start == end and pointing to the largest no beacuse of the two   check avove
		return start; // or return end as both are equal
    }
}