/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */

class Solution {
    /**
     * Insert newInterval into intervals.
     * @param intervals: Sorted interval list.
     * @param newInterval: A new interval.
     * @return: A new sorted interval list.
     */
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> result = new ArrayList<Interval>();
        // write your code here
        int start = newInterval.start, end = newInterval.end;
        boolean bool = true;
        for(int i = 0; i < intervals.size(); i ++){
            Interval temp = intervals.get(i);
            if(temp.end < newInterval.start){
                result.add(temp);
            }
            else if(temp.start > newInterval.end){
                if(bool){
                    bool = false;
                    result.add(new Interval(start, end));
                }
                result.add(temp);
            }
            else {
                start = Math.min(start, temp.start);
                end = Math.max(end, temp.end);
            }
        }
        if(bool){
            result.add(new Interval(start, end));
        }
        return result;
    }
}
