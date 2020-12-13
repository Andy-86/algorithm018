package com.andy.week8;

public class InsertSort {
    public static void main(String[] args) {
        int[] array = new int[] {4, 7, 9, 3, 6, 1, 65, 7, 8, 3, 34, 0, 55, 87, 10, 434, 82, 19, 44, 2, 9, 323, 898, 635, 294, 97395};
        insertSort(array);
        for (int i = 0; i < array.length; ++i) {
            System.out.print(array[i] + " ");
        }
    }

    private static void insertSort(int[] array) {
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
    }

    public static void swap(int[] array, int idx, int idy) {
        int tem = array[idx];
        array[idx] = array[idy];
        array[idy] = tem;
    }
}
