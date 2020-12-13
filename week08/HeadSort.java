package com.andy.week8;

/**
 * @author mac
 */
public class HeadSort {
    public static void main(String[] args) {
        int[] array = new int[] {4, 7, 9, 3, 6, 1, 65, 7, 8, 3, 34, 0, 55, 87, 10, 434, 82, 19, 44, 2, 9, 323, 898, 635, 294, 97395};
        headSort(array);
        for (int i = 0; i < array.length; ++i) {
            System.out.print(array[i] + " ");
        }
    }

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

    public static void swap(int[] array, int i, int j) {
        int tem = array[i];
        array[i] = array[j];
        array[j] = tem;
    }
}
