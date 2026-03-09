class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<int[]> dq = new ArrayDeque<>();
        int[] res = new int[n-k+1];
        for (int i=0; i<n; i++) {
            // check if the last element in the queue is out of window?
            while (!dq.isEmpty() && dq.peekFirst()[1]<i-k+1) {
                dq.pollFirst();
            }

            // check if decresing order will be maintained after adding the current value?
            while (!dq.isEmpty() && dq.peekLast()[0]<nums[i]) {
                dq.pollLast();
            }
            dq.offerLast(new int[]{nums[i], i});

            if (i >= k-1) {
                res[i-k+1] = dq.peekFirst()[0];
            }
        }
        return res;
    }
}