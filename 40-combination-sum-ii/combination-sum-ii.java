import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(candidates);

        help(ans, new ArrayList<Integer>(), candidates, 0, target);

        return ans;
    }

    public void help(List<List<Integer>> ans,
                     List<Integer> temp,
                     int[] candidates,
                     int start,
                     int remain) {

        if (remain < 0) {
            return;
        }

        else if (remain == 0) {
            ans.add(new ArrayList<>(temp));
        }

        else {

            for (int i = start; i < candidates.length; i++) {

                // Skip duplicate elements
                if (i > start && candidates[i] == candidates[i - 1]) {
                    continue;
                }

                temp.add(candidates[i]);

                help(ans, temp, candidates, i + 1,
                        remain - candidates[i]);

                temp.remove(temp.size() - 1);
            }
        }
    }
}