class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int[] ans = new int[nums.length];
        int idx = 0;
        for (int i : nums) {
            if (i < pivot) 
                ans[idx++] = i;

        }

        for (int i : nums) {
            if (i == pivot) 
                ans[idx++] = i;
        }

        for (int i : nums) {
            if (i > pivot) 
                ans[idx++] = i;

        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna