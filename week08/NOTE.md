学习笔记
## 位运算
###常见操作
- 将 x 最右边的 n 位清零 (~0 << n) & x
- 获取 x 的第 n 位值（0 或者 1）(x >> n) & 1
- 获取 x 的第 n 位的幂值：(1 << n) & x
- 仅将第 n 位置为 1 (1 << n) | x
- 仅将第 n 位置为 0 ~(1 << n) & x
- 将 x 最高位至第 n 位（含）清零：((1 << n) - 1) & x
- x % 2 = x & 1
- x / 2 = x >> 1
- x最后一位1清零 x & (x - 1) 
- 获取x的最后一位的1 x & -x   

### 题解
输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数
```
while (n != 0) {
            n &= n - 1;
            step++;
        }
```

##Bloom过滤器
### 解释：将一位值通过映射函数映射（一般使用hash）到一个集合里面，（比如说一个二进制数组）,每次判断是否在数组里，只需要求hash，然后和二进制数组相与是否与自己相等 bloom 最大的作用是能在O(1)的时间复杂度内判断一个元素是否在集合内，而且占用很少内存
##LRU cache
### 解释：最近最少使用缓存算法，将使用最老没有使用的元素删除
### 实现 （使用双向链表和hashMap）
```java
    class LRUCache {
    
        int capacity;
    
        DNode head;
    
        DNode tail;
    
        int size;
    
        Map<Integer, DNode> cache;
    
        class DNode {
            int key;
    
            int value;
    
            DNode pre;
    
            DNode next;
        }
    
        public LRUCache(int capacity) {
            this.capacity = capacity;
            cache = new HashMap<>(capacity);
            tail = new DNode();
            head = new DNode();
            tail.pre = head;
            head.next = tail;
        }
    
        public int get(int key) {
            DNode node = cache.get(key);
            if (node != null) {
                add2Head(node);
                return node.value;
            }
            return -1;
        }
    
        public void put(int key, int value) {
            DNode node = cache.get(key);
            if (node == null) {
                node = new DNode();
                node.key = key;
                node.value = value;
                addHead(node);
                cache.put(key, node);
                size++;
                if (size > capacity) {
                    DNode tailNode = removeTail();
                    cache.remove(tailNode.key);
                    size--;
                }
            } else if (node.value != value) {
                node.value = value;
                add2Head(node);
            } else {
                add2Head(node);
            }
        }
    
        public void add2Head(DNode node) {
            remove(node);
            addHead(node);
        }
    
        public void addHead(DNode node) {
            node.pre = head;
            node.next = head.next;
            node.next.pre = node;
            head.next = node;
        }
    
        public void remove(DNode node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
    
        public DNode removeTail() {
            DNode tem = tail.pre;
            tem.pre.next = tail;
            tail.pre = tem.pre;
            return tem;
        }
    }

```
##排序算法
### （n*n） 排序算法
#### 选择
```
for (int i = 0; i < array.length; ++i) {
            int minIdx = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[minIdx] > array[j]) {
                    minIdx = j;
                }
            }
            if (i != minIdx) {
                swap(array, i, minIdx);
            }
        }
```
#### 插入
```
for (int i = 1; i < array.length; ++i) {
            if (array[i] < array[i - 1]) {
                int tem = array[i];
                int k = i;
                for (; k > 0 && tem < array[k - 1]; k--) {
                    array[k] = array[k - 1];
                }
                array[k] = tem;
            }
        }
```
#### 冒泡
```
for (int i = array.length - 1; i > 0; i--) {
            int maxIdx = 0;
            for (int j = 1; j <= i; j++) {
                if (array[maxIdx] < array[j]) {
                    maxIdx = j;
                }
                swap(array, maxIdx, i);
            }
        }
```
### nlogn 排序算法
#### 快排，主要是 partition 函数 (这里需要注意就是中间值快排是不在下一次的递归过程的，而归并由于无法确定mid是否是中间值所以需要继续排序)
```
public static void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int partition = partition(array, left, right);
        quickSort(array, left, partition - 1);
        quickSort(array, partition + 1, right);
    }

    public static int partition(int[] array, int left, int right) {
        int piv = right;
        int counter = left;
        for (int i = left; i < right; i++) {
            if (array[i] < array[piv]) {
                swap(array, i, counter);
                counter++;
            }
        }
        swap(array, counter, piv);
        return counter;
    }
```
#### 归并排序 (快排是将排序动作放到递归开始前，而归并放在递归完成后，归并相当于快排的逆过程)
```
if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        // 先递归
        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);
        int[] tem = new int[right - left + 1];
        int l = left;
        int r = mid + 1;
        int i = 0;
        // 后排序
        for (; l <= mid && r <= right; ) {
            tem[i++] = array[l] < array[r] ? array[l++] : array[r++];
        }
        while (l <= mid) {
            tem[i++] = array[l++];
        }
        while (r <= right) {
            tem[i++] = array[r++];
        }
        System.arraycopy(tem, 0, array, left, tem.length);
```
#### 堆排序（先初始化堆，得到最大堆后 一直取堆顶放到需要排列的第n位，然后继续堆化 n - 1 个元素）
```
public static void headSort(int[] array) {
        for (int i = array.length / 2; i >= 0; i--) {
            headify(array, array.length, i);
        }
        for (int i = array.length - 1; i >= 0; i--) {
            swap(array, i, 0);
            headify(array, i, 0);
        }
    }

public static void headify(int[] array, int length, int i) {
        int largest = i;
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        if (left < length && array[largest] < array[left]) {
            largest = left;
        }
        if (right < length && array[largest] < array[right]) {
            largest = right;
        }
        if (i != largest) {
            swap(array, i, largest);
            headify(array, length, largest);
        }
    }
```