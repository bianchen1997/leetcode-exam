import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int maxProfit(int[] prices) {
        System.out.println(getMax(prices));
        prices  = remove(prices);
        System.out.println(getMax(prices));
        prices  = remove(prices);
        System.out.println(getMax(prices));
        prices  = remove(prices);
        System.out.println(getMax(prices));
        prices  = remove(prices);
        return 0;
    }

    public int getMax(int[] prices) {
        if (prices.length <= 1)
            return 0;
        int max = 0, min = prices[0];
        int maxNum = 0, minNum = 0;
        for (int i = 0; i < prices.length; i++) {
            max = Math.max(max, prices[i] - min);
            if (max < prices[i] - min) {
                max = prices[i] - min;
                maxNum = i;
            }

            if (min > prices[i] - min) {
                min = prices[i];
                minNum = i;
            }
        }

        prices[minNum] = 0;
        prices[maxNum] = 0;

        return max;
    }

    public int[] remove(int[] arrays) {
        List<Integer> list = new ArrayList<>();
        for (int num : arrays)
            if(num!=0) list.add(num);
        int[] newArrays = new int[list.size()];
        for (int i = 0; i < newArrays.length; i++) {
            newArrays[i] = list.get(i);
        }
        return newArrays;
    }

    public static void main(String[] args) {
        int[] ints = new Solution().searchRange(new int[]{2,2}, 1);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

    public int[] searchRange(int[] nums, int target) {
        int left = searchLeft(nums, target);
        int right = searchRight(nums, target);
        return new int[] {left,right};
    }

    public int searchLeft(int[] nums, int target) {
        int left = 0;
        int size = nums.length-1;
        int right = size;

        while(left < right) {
            int mid = left + (right-left) / 2;
            if(nums[mid] == target) {
                right = mid ;
            } else if (nums[mid]> target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if(nums[left]==target)return left;
        return -1;
    }

    public int searchRight(int[] nums, int target) {
        int left = 0;
        int size = nums.length-1;
        int right = size;

        while(left < right) {
            int mid = left + (int)Math.ceil((right-left) / 2.0);
            if(nums[mid] == target) {
                left = mid ;
            } else if (nums[mid]> target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if(nums[right]==target)return right;
        return -1;
    }
}