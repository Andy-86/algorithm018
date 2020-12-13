package com.andy.week8;

/**
 * @author mac
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] array = new int[] {4, 7, 9, 3, 6, 1, 65, 7, 8, 3, 34, 0, 55, 87, 10, 434, 82, 19, 44, 2, 9, 323, 898, 635, 294, 97395};
        SelectSort(array);
        for (int i = 0; i < array.length; ++i) {
            System.out.print(array[i] + " ");
        }
    }

    public static void SelectSort(int[] array) {
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
    }

    public static void swap(int[] array, int idx, int idy) {
        int tem = array[idx];
        array[idx] = array[idy];
        array[idy] = tem;
    }
}
