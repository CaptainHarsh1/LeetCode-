class Solution {
    public int closestTarget(String[] words, String target, int start) {
        int min = Integer.MAX_VALUE;
        int n = words.length;

        for (int i = 0; i < n; i++) {
            if (words[i].equals(target)) {
                int diff = Math.abs(start - i);
                int dist = Math.min(diff, n - diff);
                min = Math.min(min, dist);
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
}