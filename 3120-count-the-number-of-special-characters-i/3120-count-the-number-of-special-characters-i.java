class Solution {
    public int numberOfSpecialChars(String word) {
        
        HashSet<Character> set = new HashSet<>();

        for(char ch : word.toCharArray()) {
            set.add(ch);
        }

        int count = 0;

        for(char ch = 'a'; ch <= 'z'; ch++) {

            if(set.contains(ch) && set.contains((char)(ch - 'a' + 'A'))) {
                count++;
            }
        }

        return count;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna