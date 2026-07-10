class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s:strs)
        {
            int len = s.length();
            sb.append(len+"#"+s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        int num = 0;
        int len = str.length();
        StringBuilder sb = new StringBuilder();
        List<String> ans = new ArrayList<>();
        for(int i=0;i<len;i++)
        {
            while(Character.isDigit(str.charAt(i)))
            {
                num = num*10+(str.charAt(i) - '0');
                i++;
            }
            i++;
            int j=i;
            while(j<i+num)
            {
                sb.append(str.charAt(j));
                j++;
            }
            ans.add(sb.toString());
            i=j-1;
            num = 0;
            sb = new StringBuilder();
        }
        return ans;
    }
}
