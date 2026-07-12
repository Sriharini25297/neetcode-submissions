class Solution {
    int decode(int i,String s,int dp[])
    {
        if(i==s.length())
            return 1;
        if(s.charAt(i) == '0')
            return 0;
        if(dp[i]!=-1)
            return dp[i];
        int res = decode(i+1,s,dp);
        if(i<s.length()-1)
        {
            if(s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i+1) < '7'))
            {
                res+=decode(i+2,s,dp);
            }
        }
        return dp[i]=res;
    }
    public int numDecodings(String s) {
        if(s.charAt(0) == '0')
            return 0;
        int dp[] = new int[s.length()];
        Arrays.fill(dp,-1);
        return decode(0,s,dp);
        
    }
}
