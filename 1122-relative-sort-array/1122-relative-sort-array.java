class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int [] count = new int[1001];
        //frequency find
        for(int i = 0; i<arr1.length; i++){
            count[arr1[i]]++;
        }
        int index = 0;
        for(int i = 0; i<arr2.length; i++){
            int num = arr2[i];
            while(count[num] > 0){
                arr1[index] = num;
                index++;
                count[num]--;
            }
        }
        for(int i =0; i<count.length; i++){
            while(count[i] > 0){
                arr1[index] = i;
                index++;
                count[i]--;
            }
        }
        return arr1;
    }
}