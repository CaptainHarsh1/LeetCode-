class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] numFreq = new int[101];
        int maxFreq = 0;
        int maxFreqElementCount = 0;
        for(int num :  nums) {
            numFreq[num]++;
            if(numFreq[num] == maxFreq) {
                maxFreqElementCount += numFreq[num];
            }
            if(numFreq[num] > maxFreq) {
                maxFreqElementCount = numFreq[num];
                maxFreq = numFreq[num];
            }
        }
        return maxFreqElementCount;
        
    }
}