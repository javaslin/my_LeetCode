package leetcode;

public class MaxArea {

    public int maxArea(int[] height) {
        int res = 0;
        int i = 0, j = height.length - 1;

        while (i < j) {
            int area = (j - i) * Math.min(height[i], height[j]);
            res = Math.max(res, area);
            if (height[i] < height[j]) {
                i++;
            } else if (height[i] > height[j]) {
                j--;
            } else {
                i++;
            }
        }

        return res;

    }
}
