package leetcode;

/*
443. 压缩字符串
给定一组字符，使用原地算法将其压缩。

压缩后的长度必须始终小于或等于原数组长度。

数组的每个元素应该是长度为1 的字符（不是 int 整数类型）。

在完成原地修改输入数组后，返回数组的新长度。



进阶：
你能否仅使用O(1) 空间解决问题？



示例 1：

输入：
["a","a","b","b","c","c","c"]

输出：
返回6，输入数组的前6个字符应该是：["a","2","b","2","c","3"]

说明：
"aa"被"a2"替代。"bb"被"b2"替代。"ccc"被"c3"替代。
示例 2：

输入：
["a"]

输出：
返回1，输入数组的前1个字符应该是：["a"]

说明：
没有任何字符串被替代。
示例 3：

输入：
["a","b","b","b","b","b","b","b","b","b","b","b","b"]

输出：
返回4，输入数组的前4个字符应该是：["a","b","1","2"]。

说明：
由于字符"a"不重复，所以不会被压缩。"bbbbbbbbbbbb"被“b12”替代。
注意每个数字在数组中都有它自己的位置。
注意：

所有字符都有一个ASCII值在[35, 126]区间内。
1 <= len(chars) <= 1000。

这个题目的细节需要很多注意的地方，测试用例比较刁钻，甚至出现过统计过后的次数比如是2，然后后面的字符他也思路没什么问题，用一个变量index表示新的压缩后字符串的位置。

因为题目要求要原地翻转，所以只能是用前面28.移动零的那种覆盖的方式了，统计次数然后变成char数组之后放在统计的那个字符的第一个字符后面覆盖掉后面的元素。

注意如果只有一个字符，也就是time == 1的情况下是不需要压缩的，直接就把这个字符拿过来就好了。

 */
public class Compress {

    public int compress(char[] chars) {
//        if (chars.length == 0 || chars == null) {
//            return 0;
//        }
//        if (chars.length == 1) {
//            return 1;
//        }
//        Arrays.sort(chars);
//        Map<Character,Integer> map=new HashMap<>();
//        for (int i = 0; i <chars.length ; i++) {
//            if(!map.containsKey(chars[i])){
//                map.put(chars[i],0);
//            }
//            if(map.containsKey(chars[i])){
//                int a=map.get(chars[i]);
//                a++;
//                map.put(chars[i],a);
//            }
//        }
//        int count=map.size();
//        for(Character key : map.keySet()) {
//            int value = map.get(key);
//            if (value>=1){
//                count++;
//            }
//            if (value >= 10) {
//                count++;
//            }
//            if (value >= 100) {
//                count++;
//            }
//        }
//        return count;
        int index = 0;
        if (chars.length < 2)
            return chars.length;
        for (int i = 0; i < chars.length; ) {
            int times = 1;
            chars[index++] = chars[i++];
            while (i < chars.length && chars[i] == chars[i - 1]) {
                times++;
                i++;
            }
            if (times > 1) {
                char[] chs = String.valueOf(times).toCharArray();
                for (int j = 0; j < chs.length; j++)
                    chars[index++] = chs[j];
            }
        }
        return index;
    }

    public static void main(String[] args) {
        Compress compress = new Compress();
        char[] chars = new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c'};
        System.out.println(compress.compress(chars));

    }
}
