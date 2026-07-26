class Solution {

    public long subArrayRanges(int[] nums) {
        return sumMax(nums) - sumMin(nums);
    }

    private long sumMax(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        long ans = 0;

        for (int i = 0; i <= nums.length; i++) {
            while (!stack.isEmpty() &&(i == nums.length || nums[stack.peek()] <= nums[i])) {

                int mid = stack.pop();

                int left = stack.isEmpty() ? -1 : stack.peek();
                int right = i;

                ans += (long) nums[mid] * (mid - left) * (right - mid);
            }
            stack.push(i);
        }
        return ans;
    }

    private long sumMin(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        long ans = 0;

        for (int i = 0; i <= nums.length; i++) {
            while (!stack.isEmpty() &&(i == nums.length || nums[stack.peek()] >= nums[i])) {

                int mid = stack.pop();

                int left = stack.isEmpty() ? -1 : stack.peek();
                int right = i;

                ans += (long) nums[mid] * (mid - left) * (right - mid);
            }
            stack.push(i);
        }
        return ans;
    }
}