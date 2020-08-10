import java.util.ArrayList;
import java.util.List;

public class Subset {


    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();

        res.add(new ArrayList<Integer>());

        for (int num : nums) {
            int size = res.size();
            for (int i = 0; i < size; i++) {
                List<Integer> subList = new ArrayList<>(res.get(i));
                subList.add(num);
                res.add(subList);
            }

        }
        return res;

    }
}
