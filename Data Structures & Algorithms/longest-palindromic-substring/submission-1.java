class Solution {
    public String longestPalindrome(String s) {
        int resLen  = 0;
        int start = -1;
        int n = s.length();
        if(n==1)
            return s;
        for(int i=0;i<n-1;i++)
        {
            int l=i;
            int r=i;
            int tempStart = -1;
            while(l>=0 && r<n && s.charAt(l) == s.charAt(r))
            {
                l--;
                r++;
            }
            int len = r-l-1;
            tempStart = l+1;
            l=i;
            r=i+1;
            while(l>=0 && r<n && s.charAt(l) == s.charAt(r))
            {
                l--;
                r++;
            }
            if(r-l-1>len)
            {
                len = r-l-1;
                tempStart = l+1;
            }
            if(len>resLen)
            {
                resLen = len;
                start = tempStart;
            }
        }
        return s.substring(start,start+resLen);
    }
}
