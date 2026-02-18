class Solution {
    public boolean hasAlternatingBits(int n) {
        int val=n&1;

        while(n!=0){
            n=n>>1;
            if(val==(n&1)) return false;
            val=n&1;            
        }
        
        return true;
    }
}