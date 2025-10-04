

class Solution {
    public List<Integer> targetIndices(int[] arr, int target) {
        // Step 1: sort array (bubble sort call karo)
        bubble(arr);

        // Step 2: traverse & collect indices
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                result.add(i);
            }
        }
        return result;
    }

    // Bubble sort function
    static void bubble(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j] < arr[j - 1]) {
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
    }
}
