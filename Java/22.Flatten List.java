/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer,
 *     // rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds,
 *     // if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds,
 *     // if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
    
    // @param nestedList a list of NestedInteger
    // @return a list of integer
    public List<Integer> flatten(List<NestedInteger> nestedList) {
        // Write your code here
        ArrayList<Integer> ans = new ArrayList<Integer>();
        Queue<NestedInteger> queue = new LinkedList<NestedInteger>();
        for(NestedInteger temp : nestedList){
            helper(temp, ans);
        }
        return ans;
    }
    private void helper(NestedInteger ni, ArrayList<Integer> ans){
        if(ni.isInteger()){
            ans.add(ni.getInteger());
            return;
        }
        for(NestedInteger temp : ni.getList()){
            helper(temp, ans);
        }
        return;
    }
}
