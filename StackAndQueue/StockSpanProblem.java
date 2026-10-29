import java.util.Stack;
import java.util.Arrays;

public class StockSpanProblem {

    static int[] calculateSpan(int[] prices) {
        int n = prices.length;
        int[] span = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            // Remove days whose prices are <= today's price.
            while (!stack.isEmpty()
                    && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }

            // If the stack is empty, all previous days are included.
            span[i] = stack.isEmpty() ? i + 1 : i - stack.peek();

            // Store today's index.
            stack.push(i);
        }

        return span;
    }

    public static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 75, 85};

        int[] spans = calculateSpan(prices);

        System.out.println("Prices: " + Arrays.toString(prices));
        System.out.println("Spans:  " + Arrays.toString(spans));
    }
}