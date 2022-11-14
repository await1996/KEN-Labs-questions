package LeetCode_Algo;

class LeetCode29 {
    public int divide(int dividend, int divisor) {
        if (divisor == -1 && dividend == Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }

        int flag = 1;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            flag = -1;
        }

        int sum = dividend > 0 ? -dividend : dividend;
        int num = divisor > 0 ? -divisor : divisor;

        int res = div(sum, num);
        return flag > 0 ? res : -res;
    }

    public int div(int sum, int num) {
        if (sum > num) {
            return 0;
        }

        int cnt = 1;
        int tmp = num;
        // 溢出之后，发生数组越界时tmp+tmp会大于0
        while ((sum <= tmp + tmp) && (tmp + tmp < 0)) {
            cnt += cnt;
            tmp += tmp;
        }

        return cnt+div(sum-tmp, num);
    }
}