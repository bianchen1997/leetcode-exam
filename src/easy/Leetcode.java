package easy;

public class Leetcode {

    public static void main(String[] args) {
        System.out.println(num38(50));
    }

    public static String num38(int num) {
        if (num == 1) return String.valueOf(num);

        String preString = num38(num-1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < preString.length(); i++) {
            int count = 1;
            while (i < preString.length() - 1 && preString.charAt(i) == preString.charAt(i+1)) {
                i++;
                count++;
            }
            sb.append(count);
            sb.append(preString.charAt(i));
        }
        return sb.toString();
    }
}
