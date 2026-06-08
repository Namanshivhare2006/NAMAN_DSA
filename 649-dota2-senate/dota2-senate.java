class Solution {

    public String predictPartyVictory(String senate) {

        StringBuilder sb = new StringBuilder(senate);

        int rCount = 0;

        for(char ch : senate.toCharArray()) {
            if(ch == 'R') rCount++;
        }

        int dCount = senate.length() - rCount;

        int idx = 0;

        while(rCount > 0 && dCount > 0) {

            char curr = sb.charAt(idx);

            int j = (idx + 1) % sb.length();

            if(curr == 'R') {

                while(sb.charAt(j) != 'D') {
                    j = (j + 1) % sb.length();
                }

                sb.deleteCharAt(j);
                dCount--;

            } else {

                while(sb.charAt(j) != 'R') {
                    j = (j + 1) % sb.length();
                }

                sb.deleteCharAt(j);
                rCount--;
            }

            if(sb.length() == 0) break;

            if(j < idx) idx--;

            idx = (idx + 1 + sb.length()) % sb.length();
        }

        return rCount > 0 ? "Radiant" : "Dire";
    }
}