class Solution {
    Boolean dp[];
    boolean isPossible(String s,Set<String> st,int idx)
    {
        if(idx == s.length())
            return true;
        if(dp[idx]!=null)
            return dp[idx];
        StringBuilder sb = new StringBuilder();
        for(int i=idx;i<s.length();i++)
        {
            sb.append(s.charAt(i));
            if(st.contains(sb.toString()))
            {
                if(isPossible(s,st,i+1))
                    return dp[idx] = true;
            }
        }
        return dp[idx] = false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> st = new HashSet<>();
        dp = new Boolean[s.length()];
        for(String str:wordDict)
        {
            st.add(str);
        }
        return isPossible(s,st,0);
    }
}
