public class JZOffer49 {
    public int nthUglyNumber(int n) {
        if(n==0) return 0;
        int[] result = new int[n+1];
        result[1] = 1;
        for(int i=2;i<=n;i++) {
            int begin = result[i-1] + 1;
            while (true) {
                if(begin % 2==0 || begin % 3==0||begin %5==0) break;
                else begin++;
            }
            result[i] = begin;
        }

        for (int i : result) {
            System.out.println(i);
        }

        return result[n];
    }

    public static void main(String[] args) {
        System.out.println(new JZOffer49().nthUglyNumber(11));
    }


}
