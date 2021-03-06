> 指导思想：又快又优雅，快到一定程度的时候，要停下来让代码自己说话

要求最多买卖两次，那么每天都会有五种状态：不买、买一次、卖一次、买两次、卖两次。

而这五种状态赚的钱的转换规律为：

1. 总不买 = 0；
2. 买一次 = **买过一次，这次不卖**或者**没买过，　这次买**。
3. 卖一次 = **卖过一次，这次不买**或者**买过一次，这次卖**。
4. 买两次 = **买过两次，这次不卖**或者**卖过一次，这次买**。
5. 卖两次 = **卖过两次，没机会了**或者**买过两次，这次卖**。

惨了，不认识买跟卖这两个字了。。。

以 0 到 4 代表上面五种状态，并且买就要花钱，卖就要赚钱（你可以在 10 的时候买入 8 卖出，这样就亏了 2），
可以画出这样的表格(没时间做动画，搞个动画秒懂了)：

* 0：没买过。　 => `dp[i][0] = 0`
* 1：买过 1 次。=> `dp[i][1] = Math.max(dp[i - 1][0] - price[i], dp[i - 1][1])`
* 2：卖过 1 次。=> `dp[i][2] = Math.max(dp[i - 1][1] + price[i], dp[i - 1][2])`
* 3：买过 2 次。=> `dp[i][3] = Math.max(dp[i - 1][2] - price[i], dp[i - 2][3])`
* 4：买过 2 次。=> `dp[i][4] = Math.max(dp[i - 1][3] + price[i], dp[i - 2][4])`

表格里面写计算过程太占用空间，直接写结果，过程可以通过上面的公式推：

|状　态| 3 | 3 | 5 | 0 | 0 | 3 | 1 | 4 |
|:- | :-: | :-: | :-: | :-: | :-: | :-: | :-: | :-: |
|总不买| 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 |
|买一次| -3 | -3 | -3 | 0 | 0 | 0 | 0 | 0 |
|卖一次| x | 0 | 2 | 2 | 2 | 3 | 3 | 4 |
|买两次| x | x | -5 | 2 | 2 | 2 | 2 | 2 |
|卖两次| x | x | x | -5 | 2 | 5 | 5 | 6 |
|**结果**| **0** | **0** | **2** | **2** | **2** | **5** | **5** | **6** |

为了让代码更优雅，我在第一天之前设置了个第 0 天，同时用 Integer.MIN_VALUE 表示表格中的 `x`；

~~~java
    public int maxProfit(int[] prices) {
        long[][] dp = new long[prices.length + 1][5];
        for (long[] dayStatus : dp) {
            Arrays.fill(dayStatus, Integer.MIN_VALUE);
        }
        dp[0][0] = 0; // 第零天的“没买过”状态的收入值是 0，其他都为 Integer.MIN_VALUE 表示没计算过
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = 0;
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i - 1]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i - 1]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i - 1]);
            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i - 1]);
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < dp[prices.length].length; i++) {
            res = Math.max(res, (int)dp[prices.length][i]);
        }
        return res;
    }
~~~