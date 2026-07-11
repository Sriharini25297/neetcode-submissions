class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans  = new ArrayList<>();
        int end = 0;
        int n = s.length();
        Map<Character,Integer> mp = new HashMap<>();
        for(int i=0;i<n;i++)
        {
            char ch = s.charAt(i);
            if(mp.containsKey(ch))
                mp.remove(ch);
            mp.put(ch,i);
        }
        int left = 0;
        for(int right = 0;right<n;right++)
        {
            end = Math.max(end,mp.get(s.charAt(right)));
            if(right == end)
            {
                ans.add(right-left+1);
                end = 0;
                left = right+1;
            }
        }
        return ans;
    }
}
