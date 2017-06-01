/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
class Solution {
    /**
     * This method will be invoked first, you should design your own algorithm
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        // write your code here
        if(root == null){
            return "{}";
        }
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        list.add(root);
        for(int i = 0; i < list.size(); i ++){
            TreeNode temp = list.get(i);
            if(temp == null){
                continue;
            }
            list.add(temp.left);
            list.add(temp.right);
        }
        while(list.get(list.size() - 1) == null) {
            list.remove(list.size() - 1);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append(list.get(0).val);
        for(int i = 1; i < list.size(); i ++) {
            TreeNode temp = list.get(i);
            if(temp == null){
                sb.append(",#");
            }
            else {
                sb.append(",");
                sb.append(temp.val);
            }
        }
        sb.append("}");
        return sb.toString();
    }
    
    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        // write your code here
        if(data.equals("{}")){
            return null;
        }
        String[] vals = data.substring(1, data.length() - 1).split(",");
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        list.add(root);
        boolean isLeft = true;
        int index = 0;
        for(int i = 1; i < vals.length; i ++){
            if(!vals[i].equals("#")){
                TreeNode temp = new TreeNode(Integer.parseInt(vals[i]));
                if(isLeft){
                    list.get(index).left = temp;
                }
                else {
                    list.get(index).right = temp;
                }
                list.add(temp);
            }
            if(!isLeft){
                index ++;
            }
            isLeft = !isLeft;
        }
        return root;
    }
}

