class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] sorted = arr.clone();

        Arrays.sort(sorted);

        HashMap<Integer, Integer> rank = new HashMap<>();
        int currentRank = 1;

        for (int num : sorted) {
            if (!rank.containsKey(num)) {
                rank.put(num, currentRank++);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = rank.get(arr[i]);
        }

        return arr;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna