package com.andy.week8;

/**
 * @author mac
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] array = new int[] {4, 7, 9, 3, 6, 1, 65, 7, 8, 3, 34, 0, 55, 87, 10, 434, 82, 19, 44, 2, 9, 323, 898, 635, 294, 97395};
        mergeSort(array, 0, array.length - 1);
        for (int i = 0; i < array.length; ++i) {
            System.out.print(array[i] + " ");
        }
    }

    /**
     * @param array
     * @param left
     * @param right
     */
    public static void mergeSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);
        int[] tem = new int[right - left + 1];
        int l = left;
        int r = mid + 1;
        int i = 0;
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
    }
}
