class Solution {
    public String processStr(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (ch == '*') {
                if (sb.length() != 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            } 
            else if (ch == '#') {
                sb.append(sb);
            } 
            else if (ch == '%') {
                sb.reverse();
            } 
            else if (ch >= 'a' && ch <= 'z') {
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna