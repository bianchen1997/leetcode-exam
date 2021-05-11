import java.util.Arrays;

public class JZOffer61 {
    public static boolean isStraight(int[] nums) {
        Arrays.sort(nums);

        int count = 0;
        for(int i=0;i<nums.length;i++)
            if(nums[i]==0) count++;

        if(count == nums.length || count == nums.length-1) return true;

        for(int i=count+1,cur = nums[count];i<nums.length;i++,cur++) {
            if(cur == nums[i]) return false;
            else if(cur+1 == nums[i]) {
                continue;
            } else if(count != 0) {
                count--;
                i--;
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isStraight(new int[]{1, 2, 12, 0, 3}));
    }
}
