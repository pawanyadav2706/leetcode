class Solution {
    public int minSetSize(int[] arr) {
        int half = arr.length / 2;
        int max = arr[0];
        for(int i = 1; i<arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        int [] countarr = new int[max + 1];
        for(int i =0; i<arr.length; i++){
            countarr[arr[i]]++;
        }
        int [] freq = new int [arr.length + 1];
        for(int i =0; i<countarr.length; i++){
            if(countarr[i] > 0){
                freq[countarr[i]]++;
            }
        }
        int total = 0;
        int ans = 0;
        for(int i = freq.length - 1; i >= 0; i--){

            while(freq[i] > 0){
                total += i;
                ans++;

                if(total >= half){
                    return ans;
                }

                freq[i]--;
            }
        }

        return ans;
    }
}