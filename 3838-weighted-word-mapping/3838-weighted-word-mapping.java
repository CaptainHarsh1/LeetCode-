class Solution {
    public String mapWordWeights(String[] words, int[] wt) {
        StringBuilder sb = new StringBuilder();

        for (String word : words) {
            int s = 0;
            for (int i = 0; i < word.length(); i++) 
                s += wt[(word.charAt(i) & (1 << 5) - 1) - 1];
            
            sb.append((char) ('z' - (s - ((s * 2521) >> (1 << 4)) * 26)));
        }

        return sb.toString();
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna