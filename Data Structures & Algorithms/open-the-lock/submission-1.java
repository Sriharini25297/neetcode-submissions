class Pair{
    String str;
    int turn;
    Pair(String str,int turn)
    {
        this.str = str;
        this.turn = turn;
    }
}
class Solution {
    public int openLock(String[] deadends, String target) {
       Queue<Pair> q = new LinkedList<>();
       Set<String> st = new HashSet<>();
       for(String s:deadends)
       {
        st.add(s);
       }
       if(st.contains("0000"))
        return -1;
        q.offer(new Pair("0000",0));
        while(!q.isEmpty())
        {
            Pair curr = q.poll();
            String end = curr.str;
            int cost = curr.turn;
            if(end.equals(target))
                return cost;
            for(int i=0;i<4;i++)
            {
                int digit = end.charAt(i)-'0';
                int up = (digit+1)%10;
                int down = (digit+9)%10;
                String s1 = end.substring(0,i)+(char)(up+'0')+end.substring(i+1);
                String s2 = end.substring(0,i)+(char)(down+'0')+end.substring(i+1);
                if(!st.contains(s1))
                {
                    st.add(s1);
                    q.offer(new Pair(s1,cost+1));
                }
                if(!st.contains(s2))
                {
                    st.add(s2);
                    q.offer(new Pair(s2,cost+1));
                }
            }
        }
        return -1;
    }
}