class Solution {
    int count = 0;

    int size;

    public int totalNQueens(int n) {
        // 构造一个长度为n然后全是1的数组
        size = (1 << n) - 1;
        dsf(0, 0, 0);
        return count;
    }

    void dsf(int row, int pie, int na) {
        // 只需要关注长度为n的数组内是否有冲突即可，假如超过了n就是对这一行插入元素没有任何影响
        if (size == row) {
            count++;
            return;
        }
        int pos = size & (~(row | pie | na));
        // 循环所有对位置
        while (pos != 0) {
            // 取最低一位对幂值
            int p = pos & -pos;
            // 最后一位清零
            pos &= pos - 1;
            //drill down 对下一行对影响 pie 即左移一位， na 即右移一位
            dsf(row | p, (pie | p) << 1, (na | p) >> 1);
        }
    }
}
