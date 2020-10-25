class Solution {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int current = 0;
        int sum = 0;
        while (current < height.length) {
            while (!stack.empty() && height[stack.peek()] < height[current]) {
                int buttom = height[stack.pop()];
                if (stack.empty()) {
                    break;
                }
                int min = Math.min(height[stack.peek()], height[current]);
                int distance = current - stack.peek() - 1;
                sum += distance * (min - buttom);
            }
            stack.push(current);
            current++;
        }
        return sum;
    }
}
