import java.util.*;

public class Main {
    //测试
    //i want something just like this
    public static int maxSubArray(int[] nums) {
        int max = nums[0];
        int pre = 0;
        for (int num : nums) {
            pre = Math.max(pre + num, num);
            max = Math.max(pre, max);
        }
        return max;
    }


    public static int lengthOfLastWord(String s) {
        //if(s.equals(" ")) return 0;
        String[] strs = s.split(" ");
        return strs.length > 0 ? strs[strs.length - 1].length() : 0;
    }

    //1480
    public int[] runningSum(int[] nums) {
        int[] sumNums = new int[nums.length];
        int currentSum = 0;
        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            sumNums[i] = currentSum;
        }

        return sumNums;
    }

    //66
    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    //jzoffer58
    public static String reverseLeftWords(String s, int n) {

        return s.substring(n) + s.substring(0, n);
    }

    //67
    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int current = 0;

        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int sum = current;
            sum += i >= 0 ? a.charAt(i) - '0' : 0;
            sum += j >= 0 ? b.charAt(j) - '0' : 0;
            sb.append(sum % 2);
            current = sum / 2;
        }

        sb.append(current == 0 ? "" : 1);
        return sb.reverse().toString();
    }

    public static int mySqrt(int x) {
        int i = 46340;
        while ((long) i * i <= x)
            i++;
        return i - 1;
    }

    public static int maximumWealth(int[][] accounts) {
        int height = accounts.length;
        int length = accounts[0].length;
        int max = accounts[0][0];
        int temp = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < length; j++) {
                temp += accounts[i][j];
            }
            max = max < temp ? temp : max;
            temp = 0;
        }
        return max;
    }

    public static int climbStairs(int n) {
        if (n <= 2)
            return n;
        int first = 1, second = 2, third = 0;
        for (int i = 2; i < n; i++) {
            third = first + second;
            first = second;
            second = third;
        }
        return third;
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m, j = 0; i < m + n; i++, j++) {
            nums1[i] = nums2[j];
        }
        Arrays.sort(nums1);
    }

    public static int numJewelsInStones(String jewels, String stones) {
        int sum = 0;
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < jewels.length(); i++)
            list.add(jewels.charAt(i));
        for (int i = 0; i < stones.length(); i++)
            if (list.contains(stones.charAt(i)))
                sum++;
        return sum;
    }

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int count = 0;
        for (List<String> item : items) {
            count += match(item, ruleKey, ruleValue) ? 1 : 0;
        }
        return count;
    }

    public static boolean match(List<String> list, String ruleKey, String ruleValue) {
        if (ruleKey.equals("type"))
            return list.get(0).equals(ruleValue);
        if (ruleKey.equals("color"))
            return list.get(1).equals(ruleValue);
        if (ruleKey.equals("name"))
            return list.get(2).equals(ruleValue);
        return false;
    }


    //yanghuisanjiao
    public static int triangle(int i, int j) {
        if (i == 0 && j == 0)
            return 1;
        return triangle(i - 1, j - 1) + triangle(i - 1, j);
    }

    public static List<Integer> getRow(int rowIndex) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0; i< rowIndex;i++) {
            List<Integer> current = new ArrayList<>();
            for(int j=0;j<=i;j++) {
                if(j==0 || j==i)
                    current.add(1);
                else {
                    current.add(res.get(i-1).get(j-1) + res.get(i-1).get(j));
                }
            }
            res.add(current);
        }

        return res.get(rowIndex-1);
    }


    public static String say(String s) {
        char current = s.charAt(0);
        int count = 1;
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<s.length();i++) {
            if(current==s.charAt(i)) {
                count++;
            } else {
                sb.append(count);
                sb.append(current);
                current = s.charAt(i);
                count = 1;
            }
        }

        sb.append(count);
        sb.append(current);

        return sb.toString();
    }

    public static String longestCommonPrefix(String[] strs) {
        String pub = strs[0];

        int index = 1;
        int i=0;
        while(index<strs.length) {
            while(i<pub.length() && i<strs[index].length()) {
                if(pub.charAt(i) == strs[index].charAt(i))
                    i++;
                else break;
            }
            pub = pub.substring(0, i);
            index++;
            i=0;
        }

        return pub;
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"what a beautiful day", "what the fuck", "when your goon"}));
    }
}
