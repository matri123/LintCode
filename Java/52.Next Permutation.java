public class Solution {
    /**
     * @param num: an array of integers
     * @return: return nothing (void), do not return anything, modify num in-place instead
     */
    
    public void reverse(int[] num, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            int temp = num[i];
            num[i] = num[j];
            num[j] = temp;
        }
    }
    
    public int[] nextPermutation(int[] num) {
        int index = -1;
        for (int i = num.length - 2; i >= 0; i--) {
            if (num[i] < num[i + 1]) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            reverse(num, 0, num.length - 1);
            return num;
        }
        
        int biggerIndex = index + 1;
        for (int i = num.length - 1; i > index; i--) {
            if (num[i] > num[index]) {
                biggerIndex = i;
                break;
            }
        }
        
        int temp = num[index];
        num[index] = num[biggerIndex];
        num[biggerIndex] = temp;
        
        reverse(num, index + 1, num.length - 1);
        return num;
    }
}

