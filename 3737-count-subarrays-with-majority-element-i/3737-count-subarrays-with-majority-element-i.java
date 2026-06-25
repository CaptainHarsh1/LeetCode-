class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int ans = 0;

        for (int left = 0; left < n; left++) {
            int countTarget = 0;

            for (int right = left; right < n; right++) {

                if (nums[right] == target)
                    countTarget++;

                int len = right - left + 1;

                if (2 * countTarget > len)
                    ans++;
            }
        }

        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna