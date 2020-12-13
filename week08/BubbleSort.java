package com.andy.week8;

/**
 * @author mac
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] array = new int[] {4, 7, 9, 3, 6, 1, 65, 7, 8, 3, 34, 0, 55, 87, 10, 434, 82, 19, 44, 2, 9, 323, 898, 635, 294, 97395};
        bubbleSort(array);
        for (int i = 0; i < array.length; ++i) {
            System.out.print(array[i] + " ");
        }
    }

    private static void bubbleSort(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            int maxIdx = 0;
            for (int j = 1; j <= i; j++) {
                if (array[maxIdx] < array[j]) {
                    maxIdx = j;
                }
                swap(array, maxIdx, i);
            }
        }
    }

    public static void swap(int[] array, int idx, int idy) {
        int tem = array[idx];
        array[idx] = array[idy];
        array[idy] = tem;
    }
}
