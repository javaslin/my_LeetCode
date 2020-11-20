package leetcode;

import java.util.HashMap;
import java.util.Map;

/*
给定平面上 n 对不同的点，“回旋镖” 是由点表示的元组 (i, j, k) ，其中 i 和 j 之间的距离和 i 和 k 之间的距离相等（需要考虑元组的顺序）。

找到所有回旋镖的数量。你可以假设 n 最大为 500，所有点的坐标在闭区间 [-10000, 10000] 中。

示例:

输入:
[[0,0],[1,0],[2,0]]

输出:
2

解释:
两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
 */
public class NumberOfBoomerangs {
    public int numberOfBoomerangs(int[][] points) {
        int result = 0;
        Map<Integer, Integer> map;
        for (int i = 0; i < points.length; i++) {
            map = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                // 不考虑当前同样的点
                if (i != j) {
                    int distance = getDistance(points[i], points[j]);
                    map.put(distance, map.getOrDefault(distance, 0) + 1);
                }
            }
            result += getCountByPoint(map);
        }

        return result;
    }

    /**
     * 求两点之间的距离的平方, 不进行平方根操作了, 不然可能会涉及到浮点数问题
     *
     * @param pointA
     * @param pointB
     * @return
     */
    private int getDistance(int[] pointA, int[] pointB) {
        int x = pointA[0] - pointB[0];
        int y = pointA[1] - pointB[1];
        return x * x + y * y;
    }

    /**
     * 根据点的数量返回回旋镖的数量
     *
     * @return
     */
    private int getCountByPoint(Map<Integer, Integer> map) {
        int result = 0;
        for (Integer value : map.values()) {
            if (value > 1) {
                // 从n个点中选取两个点的方案数量为(n * n - 1)
                result += value * (value - 1);
            }
        }
        return result;
    }

    public int numberOfBoomerangs1(int[][] p) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>(p.length);
        for (int[] i : p) {
            for (int[] j : p) {
                int dx = i[0] - j[0];
                int dy = i[1] - j[1];
                int d = dx * dx + dy * dy;
                Integer value = map.get(d);
                if (value != null) {
                    count += 2 * value;
                    map.put(d, value + 1);
                } else
                    map.put(d, 1);
            }
            map.clear();
        }
        return count;
    }
}
