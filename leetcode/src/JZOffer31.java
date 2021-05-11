import java.util.Collections;
import java.util.Stack;

public class JZOffer31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int size = pushed.length;
        if(size == 0) return true;
        Stack<Integer> stack = new Stack<>();

        int h = 0;
        for(int i=0;i<size;i++) {
            if(pushed[i]==popped[h]) {
                h++;
            } else {
                stack.push(pushed[i]);
            }
        }

        for(int i=h;i<size;i++) {
            
            if(stack.peek()==popped[i])
                stack.pop();
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        JZOffer31 jzOffer31 = new JZOffer31();

        jzOffer31.validateStackSequences(new int[]{2,1,0},new int[]{1,2,0});
    }
}
