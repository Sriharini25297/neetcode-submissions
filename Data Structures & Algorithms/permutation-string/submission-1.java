class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length())
            return false;
        int freq1[] = new int[26];
        int freq2[] = new int[26];
        for(char ch:s1.toCharArray())
            freq1[ch-'a']++;
        int k = s1.length();
        for(int i=0;i<k;i++)
        {
            char ch = s2.charAt(i);
            freq2[ch-'a']++;
        }
        if(Arrays.equals(freq1,freq2))
            return true;
        int n = s2.length();
        for(int i=k;i<n;i++)
        {
            char toPut = s2.charAt(i);
            char toRemove = s2.charAt(i-k);
            freq2[toPut-'a']++;
            freq2[toRemove-'a']--;
            if(Arrays.equals(freq1,freq2))
                return true;
        }
        return false;
    }
}
