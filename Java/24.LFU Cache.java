public class LFUCache {
    private HashMap<Integer, int[]> num;
    private HashMap<Integer, LinkedHashSet<Integer>> time;
    private int capacity;
    private int now;
    
    // @param capacity, an integer
    public LFUCache(int capacity) {
        // Write your code here
        num = new HashMap<>();
        time = new HashMap<>();
        this.capacity = capacity;
        now = 0;
    }
    
    // @param key, an integer
    // @param value, an integer
    // @return nothing
    public void set(int key, int value) {
        // Write your code here
        if(num.containsKey(key) && num.get(key)[1] != 0){
            num.get(key)[0] = value;
            plus(key);
            return ;
        }
        if(capacity <= now) {
            if(!num.containsKey(key) || num.get(key)[1] == 0){
                remove();
            }
        }
        now ++;
        add(key, value);
    }
    
    public int get(int key) {
        // Write your code here
        int ans = -1;
        if(!num.containsKey(key) || num.get(key)[1] == 0) {
            return ans;
        }
        else {
            plus(key);
            ans = num.get(key)[0];
            return ans;
        }
    }
    
    public void add(int key, int value) {
        num.put(key, new int[]{value, 1});
        if(time.get(1) == null){
            time.put(1, new LinkedHashSet<Integer>());
        }
        time.get(1).add(key);
    }
    
    public void plus(int key) {
        int temp = num.get(key)[1];
        num.get(key)[1] ++;
        LinkedHashSet<Integer> lhs = time.get(temp);
        lhs.remove(key);
        if(!time.containsKey(temp + 1)){
            time.put(temp + 1, new LinkedHashSet<Integer>());
        }
        time.get(temp + 1).add(key);
    }
    
    public void remove() {
        int temp = -1, cur = 1;
        while(true){
            if(time.get(cur) == null || time.get(cur).size() == 0){
                cur ++;
                continue;
            }
            temp = time.get(cur).iterator().next();
            num.get(temp)[1] = 0;
            time.get(cur).remove(temp);
            break;
        }
        now --;
    }
    public void print() {
        for(int i = 0; i<4;i++){
            System.out.print(i);
            System.out.println(time.get(i));
        }
    }
}

