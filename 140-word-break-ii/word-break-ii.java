import java.util.*;

class Solution {

    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        Map<String, List<String>> memo = new HashMap<>();
        return dfs(s, set, memo);
    }

    private List<String> dfs(String s, Set<String> set, Map<String, List<String>> memo) {
        
        if (memo.containsKey(s)) {
            return memo.get(s);
        }

        List<String> result = new ArrayList<>();

        if (s.length() == 0) {
            result.add("");
            return result;
        }

        for (int i = 1; i <= s.length(); i++) {
            String prefix = s.substring(0, i);

            if (set.contains(prefix)) {
                List<String> suffixWays = dfs(s.substring(i), set, memo);

                for (String way : suffixWays) {
                    result.add(prefix + (way.isEmpty() ? "" : " " + way));
                }
            }
        }

        memo.put(s, result);
        return result;
    }
}