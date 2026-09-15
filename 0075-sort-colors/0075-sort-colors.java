class Solution {
    public void sortColors(int[] nums) {
      if(nums == null || nums.length <= 0){
        return;
      }
      int max = nums[0];
      for(int i = 1; i<nums.length; i++){
        if(nums[i] > max){
            max = nums[i];
        }
      }
      int [] countarr = new int[max + 1];
      for(int i =0; i<nums.length; i++){
        countarr[nums[i]]++;
      }
      int index = 0;
      for(int i = 0; i<countarr.length; i++){
        while(countarr[i] > 0){
            nums[index] = i;
            index++;

            countarr[i]--;
        }
      }
    }
}