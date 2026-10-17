class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int [][] arr = new int[n][3];
        // find digit sum
        for(int i =0; i<n; i++){
            int num = nums[i];
            int sum = 0;
            while(num > 0){
                sum += num % 10;
                num = num / 10;
            }
            arr[i][0] = nums[i];
            arr[i][1] = sum;
            arr[i][2] = i;
        }
        // accroding to question digit sum find so sort digit sum according 
        Arrays.sort(arr, (a,b) -> {
            if(a[1] != b[1]){
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });
        int [] target = new int[n];
        for(int i =0; i<n; i++){
            target[arr[i][2]] = i;
        }
        boolean [] visited = new boolean[n];
        // minimum sort the array 
        int swaps = 0;
        for(int i = 0; i<n; i++){
            if(visited[i] || target[i] == i){
                continue;
            }
            int j = i;
            int cycle = 0;
            while(!visited[j]){
                visited[j] = true;
                j = target[j];
                cycle++;
            }
            swaps = swaps + cycle - 1;
        }
        return swaps;
    }
}