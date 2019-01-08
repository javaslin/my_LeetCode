import java.util.Arrays;

/*
475. 供暖器
冬季已经来临。 你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。

现在，给出位于一条水平线上的房屋和供暖器的位置，找到可以覆盖所有房屋的最小加热半径。

所以，你的输入将会是房屋和供暖器的位置。你将输出供暖器的最小加热半径。

说明:

给出的房屋和供暖器的数目是非负数且不会超过 25000。
给出的房屋和供暖器的位置均是非负数且不会超过10^9。
只要房屋位于供暖器的半径内(包括在边缘上)，它就可以得到供暖。
所有供暖器都遵循你的半径标准，加热的半径也一样。
示例 1:

输入: [1,2,3],[2]
输出: 1
解释: 仅在位置2上有一个供暖器。如果我们将加热半径设为1，那么所有房屋就都能得到供暖。
示例 2:

输入: [1,2,3,4],[1,4]
输出: 1
解释: 在位置1, 4上有两个供暖器。我们需要将加热半径设为1，这样所有房屋就都能得到供暖。


思路:首先对加热器阵列进行分类 然后对于每个房子，通过二
分搜索找到距离最近的加热器的距离。 时间复杂度是（m + n）log（m）。
 */
public class FindRadius {
    public int findRadius(int[] houses, int[] heaters) {

        Arrays.sort(heaters);
        int radius = Integer.MIN_VALUE;

        for (int house : houses) {
            int distanceToHeater = closestHeater(heaters, house);
            radius = Math.max(radius, distanceToHeater);
        }

        return radius;
    }

    private int closestHeater(int[] heaters, int house) {
        if (heaters == null || heaters.length == 0)
            return Integer.MAX_VALUE;

        int start = 0, end = heaters.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (heaters[mid] == house)
                return 0;

            else if (heaters[mid] < house)
                start = mid;

            else
                end = mid;
        }

        return Math.min(Math.abs(house - heaters[start]),
                Math.abs(heaters[end] - house));
    }
}
