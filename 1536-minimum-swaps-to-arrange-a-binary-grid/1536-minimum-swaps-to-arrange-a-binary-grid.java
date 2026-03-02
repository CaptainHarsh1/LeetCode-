class Solution {
    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int size = 1;
        while (size < n) size <<= 1;

        int[] maxT = new int[size << 1];
        int[] sumT = new int[size << 1];
        Arrays.fill(maxT, -1);

        for (int i = 0; i < n; i++) {
            int trail = 0;
            for (int j = n - 1; j >= 0 && grid[i][j] == 0; j--) trail++;
            maxT[size | i] = trail;
            sumT[size | i] = 1;
        }

        for (int i = size - 1; i > 0; i--) {
            maxT[i] = Math.max(maxT[i << 1], maxT[(i << 1) | 1]);
            sumT[i] = sumT[i << 1] + sumT[(i << 1) | 1];
        }

        int swap = 0;
        for (int i = 0; i < n; i++) {
            int req = n - 1 - i;
            if (maxT[1] < req) return -1;

            int idx = 1;
            while (idx < size) {
                if (maxT[idx << 1] >= req) {
                    idx <<= 1;
                } else {
                    swap += sumT[idx << 1];
                    idx = (idx << 1) | 1;
                }
            }

            maxT[idx] = -1;
            sumT[idx] = 0;
            
            for (int p = idx >> 1; p > 0; p >>= 1) {
                maxT[p] = Math.max(maxT[p << 1], maxT[(p << 1) | 1]);
                sumT[p] = sumT[p << 1] + sumT[(p << 1) | 1];
            }
        }

        return swap;
    }
}