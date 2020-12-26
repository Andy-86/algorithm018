
### 题解
1.翻转单词 (使用双指针，逐个单词遍历生成)
```
        int i = s.length() - 1;
        int j = i;
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            j = i;
            while (j >= 0 && s.charAt(j) != ' ') {
                j--;
            }
            sb.append(s.subSequence(j < 0 ? 0 : j + 1,i < 0 ? 0 : i + 1));
            sb.append(' ');
            i = j - 1;
        }
```
2.最长公共子串 (采用一维数组，可以由二维演进而来，dp[i - 1][j - ] 对应temp，需要特殊保存，dp[i - 1][j] 和 dp[i][j - 1]对应 dp[j] dp[j - 1] )
```
int[] dp = new int[text2.length()+1];
        for(int i = 0; i< text1.length(); i++){
            int prev = dp[0];
            for(int j = 1; j < dp.length; j++){
                int temp = dp[j];
                if(text1.charAt(i) != text2.charAt(j-1)){
                    dp[j] = Math.max(dp[j-1], dp[j]);
                }else{
                    dp[j] = prev +1;
                }
                prev = temp;
            }
        }
```
3.最长回文串，这里主要由两种方法，一个是动态规划，dp[i][j]代表 i ～ j 是否为回文串，这里可以借鉴dp思维，假如一维解决不了就升维度，类似于股票问题，第二种就是比较直观的中心扩展
##### 动态规划
```
for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (i - j < 3) dp[j][i] = true;
                    else if (dp[j + 1][i - 1]) dp[j][i] = true;
                    if (dp[j][i] && (i - j + 1) > maxLen) {
                        maxLen = i - j + 1;
                        maxIdx = j;
                    }
                }
            }
        }
``` 
##### 中心扩展 (来源与伟伟哥)
```
public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLen = 1;
        String res = s.substring(0, 1);
        // 中心位置枚举到 len - 2 即可
        for (int i = 0; i < len - 1; i++) {
            String oddStr = centerSpread(s, i, i);
            String evenStr = centerSpread(s, i, i + 1);
            String maxLenStr = oddStr.length() > evenStr.length() ? oddStr : evenStr;
            if (maxLenStr.length() > maxLen) {
                maxLen = maxLenStr.length();
                res = maxLenStr;
            }
        }
        return res;
    }

 private String centerSpread(String s, int left, int right) {
        // left = right 的时候，此时回文中心是一个字符，回文串的长度是奇数
        // right = left + 1 的时候，此时回文中心是一个空隙，回文串的长度是偶数
        int len = s.length();
        int i = left;
        int j = right;
        while (i >= 0 && j < len) {
            if (s.charAt(i) == s.charAt(j)) {
                i--;
                j++;
            } else {
                break;
            }
        }
        // 这里要小心，跳出 while 循环时，恰好满足 s.charAt(i) != s.charAt(j)，因此不能取 i，不能取 j
        return s.substring(i + 1, j);
    }
```
### 字符串匹配算法
#### Rabin-krap 算法：主要通过在判断前先计算字符串的哈希值和当前匹配的串相等，假如相等则继续判断各个元素，这是一种经验法则，大部分能hash匹配上的字符串都相等
#### KMP 算法：由于暴力每次只能挪动一位，但我们已经知道了需要匹配但字符串，暴力法每次都需要遍历一遍字串，做了很多重复劳动，可以根据next数组来求出下一次需要挪动多少位
##### next 函数
```
void getNext(char * p, int * next)
{
	next[0] = -1;
	int i = 0, j = -1;

	while (i < strlen(p))
	{
		if (j == -1 || p[i] == p[j])
		{
			++i;
			++j;
			next[i] = j;
		}	
		else
			j = next[j];
	}
}
```
    