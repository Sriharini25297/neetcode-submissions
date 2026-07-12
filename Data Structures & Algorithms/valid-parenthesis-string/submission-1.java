class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> left = new Stack<>();
        Stack<Integer> star = new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            if(ch == '(')
                left.push(i);
            else if(ch == '*')
                star.push(i);
            else{
                if(!left.isEmpty())
                    left.pop();
                else if(!star.isEmpty())
                    star.pop();
                else
                    return false;
            }
        }
        if(left.isEmpty())
            return true;
        else{
            while(!left.isEmpty() && !star.isEmpty())
            {
                int idx1 = left.peek();
                int idx2 = star.peek();
                if(idx1>idx2)
                    return false;
                left.pop();
                star.pop();
            }
            return left.isEmpty();
        }
    }
}
