package com.andy.week8;

/**
 * @author mac
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] array = new int[] {4, 7, 9, 3, 6, 1, 65, 7, 8, 3, 34, 0, 55, 87, 10, 434, 82, 19, 44, 2, 9, 323, 898, 635, 294, 97395};
        quickSort(array, 0, array.length - 1);
        for (int i = 0; i < array.length; ++i) {
            System.out.print(array[i] + " ");
        }
    }

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

    public static void swap(int[] array, int idx, int idy) {
        int tem = array[idx];
        array[idx] = array[idy];
        array[idy] = tem;
    }
}
