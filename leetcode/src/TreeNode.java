import java.util.Arrays;
import java.util.List;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static void traverse(TreeNode root, List list) {
        if (root.left != null)
            traverse(root.left, list);

        list.add(root.val);

        if (root.right != null)
            traverse(root.right, list);

    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length<1)
            return null;
        int mid = (int)Math.floor(nums.length/2.0);
        TreeNode left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, mid));
        TreeNode right = sortedArrayToBST(Arrays.copyOfRange(nums, mid, nums.length));
        return new TreeNode(nums[mid+1], left, right);
    }

    public static void main(String[] args) {


    }
}
