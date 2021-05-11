public class JZOffer53 {
    public static void main(String[] args) {

    }

    public static int search(int[] nums, int target) {
        //查找左边界
        int left = 0;
        int right = nums.length - 1;

        while(left < right) {
            int mid = (left+right)/2;
            if(nums[mid] < target) {
                left  = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                right = mid - 1;
            }
        }

        return right;
    }
}
