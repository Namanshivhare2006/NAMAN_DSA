class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int ans = Integer.MAX_VALUE;

        for(int i = 0; i<landStartTime.length; i++){
            for(int j = 0; j<waterStartTime.length; j++){
                //land->water
                int landfinish = landStartTime[i] + landDuration[i];
                int waterstart = Math.max(landfinish, waterStartTime[j]);
                int finish1 = waterstart + waterDuration[j];

                //water->land
                int waterfinish = waterStartTime[j] + waterDuration[j];
                int landStart = Math.max(waterfinish, landStartTime[i]);
                int finish2 = landStart + landDuration[i];
                ans = Math.min(ans,Math.min(finish1, finish2));
            }
        }
        return ans;
    }
}