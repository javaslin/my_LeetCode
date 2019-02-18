package 剑指Offer;

import java.util.Stack;

//判断是否是栈弹出的序列
public class IsPopOrder {

    public boolean isPopOrder(int[] pushSequence, int[] popSequence) {
        int n = pushSequence.length;

        Stack<Integer> stack = new Stack<>();

        for (int pushIndex = 0, popIndex = 0; pushIndex < n; pushIndex++) {
            stack.push(pushSequence[pushIndex]);
            while (popIndex < n && !stack.isEmpty() && stack.peek() == popSequence[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }
        return stack.isEmpty();
    }
}
