class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        Set<Character> st = new HashSet<>();
        int maxLength = 0;
        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            while(st.contains(ch))
            {
                st.remove(s.charAt(left));
                left++;
            }
            maxLength = Math.max(maxLength,i-left+1);
            st.add(ch);
        }
        return maxLength;
    }
}
