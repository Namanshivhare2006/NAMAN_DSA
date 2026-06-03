class Solution {
    public boolean lemonadeChange(int[] bills) {
        int ten = 0;
        int five = 0;

        for (int num : bills) {
            if (num == 5) {
                five++;
            } else if (num == 10) {
                if (five > 0) {
                    five--;
                    ten++;
                } else {
                    return false;
                }
            } else if (five > 0 && ten > 0) {
                five--;
                ten--;
            } else if (five >= 3) {
                five -= 3;
            } else {
                return false;
            }
        }
        return true;
    }
}