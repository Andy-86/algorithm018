class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for (int i : bills) {
            if (i == 5) {
                five++;
            }
            if (i == 10) {
                if (five == 0) return false;
                five--;
                ten++;
            }
            if (i == 20) {
                if (ten > 0 && five > 0) {
                    five--;
                    ten--;
                } else {
                    if (five < 3) return false;
                    five -= 3;
                }
            }
        }
        return true;
    }
}