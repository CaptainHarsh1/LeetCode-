class Solution {
    public int minOperations(String s) {
        int oddp0 =0;
        int oddp1 =0;
        if(s.length()==1)return 0;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(i%2==0){
                if(ch=='0')oddp0++;
            }
            else{
                if(ch=='1')oddp0++;
            }
        }
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(i%2==1){
                if(ch=='0')oddp1++;
            }
            else{
                if(ch=='1')oddp1++;
            }
        }
        return Math.min(oddp1, oddp0);
    }
}