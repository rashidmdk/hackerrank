public class MaxSubarraySum {
    public static int maxSubArraySum(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int maxSum = nums[0];
        int currentSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    // Followong program is written in Javascript Node 13

//    function maxSubarraySum(arr) {
//        let maxSum = 0;
//        let currentSum = 0;
//        for (let i = 0; i < arr.length; i++) {
//            currentSum += arr[i];
//            if (currentSum > maxSum) {
//                maxSum = currentSum;
//            }
//            if (currentSum < 0) {
//                currentSum = 0;
//            }
//        }
//        return maxSum;
//    }


    public static void main(String[] args) {
        int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        int maxSum = maxSubArraySum(nums);
        System.out.println("The maximum sum subarray in the array is: " + maxSum);
    }
}