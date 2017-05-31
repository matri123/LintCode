//4543ms
class Solution {
    /**
     * @param n an integer
     * @return the nth prime number as description.
     */
    public int nthUglyNumber(int n) {
        // Write your code here
        List<Integer> uglys = new ArrayList<Integer>();
        uglys.add(1);
        
        int p2 = 0, p3 = 0, p5 = 0;
        for (int i = 1; i < n; i++) {
            int lastNumber = uglys.get(i - 1);
            while (uglys.get(p2) * 2 <= lastNumber) p2++;
            while (uglys.get(p3) * 3 <= lastNumber) p3++;
            while (uglys.get(p5) * 5 <= lastNumber) p5++;
            
            uglys.add(Math.min(
                               Math.min(uglys.get(p2) * 2, uglys.get(p3) * 3),
                               uglys.get(p5) * 5
                               ));
        }
        
        return uglys.get(n - 1);
    }
};

//4185ms
class Solution {
    /**
     * @param n an integer
     * @return the nth prime number as description.
     */
    public int nthUglyNumber(int n) {
        // Write your code here
        Queue<Long> pq = new PriorityQueue<Long>();
        HashSet<Long> set = new HashSet<Long>();
        Long first = Long.valueOf(1);
        pq.add(first);
        set.add(first);
        for(int i = 1; i < n; i ++){
            long temp = pq.poll();
            long temp1 = temp * 2;
            long temp2 = temp * 3;
            long temp3 = temp * 5;
            if(!set.contains(temp1)){
                pq.add(temp1);
                set.add(temp1);
            }
            if(!set.contains(temp2)){
                pq.add(temp2);
                set.add(temp2);
            }
            if(!set.contains(temp3)){
                pq.add(temp3);
                set.add(temp3);
            }
        }
        return pq.poll().intValue();
    }
};
