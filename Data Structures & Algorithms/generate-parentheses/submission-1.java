class Solution {
    void generateString(int n,String s,int op,int cc,List<String> lst)
    {
        if(s.length() == n)
        {
            lst.add(new String(s));
            return;
        }
        if(op<n/2)
        {
            generateString(n,s+'(',op+1,cc,lst);
        }if(cc<op)
        {
            generateString(n,s+')',op,cc+1,lst);
        }
        return;
    }
    public List<String> generateParenthesis(int n) {
        List<String> lst = new ArrayList<>();
        String s = new String();
        generateString(2*n,s,0,0,lst);
        return lst;
    }
}
