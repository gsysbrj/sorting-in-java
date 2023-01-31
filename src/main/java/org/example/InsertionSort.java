package org.example;

import java.util.Arrays;

public class InsertionSort {
    public static void insertionSort(int[] a) {
        int l = a.length;
        if (l < 2) return;
        for (int j = 1; j < l; j++) {
            int k = a[j];
            int i = j - 1; // 先把索引指向第一个要检查的元素的位置
            while (i >= 0 && a[i] > k) {
                a[i + 1] = a[i];
                i -= 1;
            }
            // while循环退出之后，i位置上的元素是第一个不大于k的元素，因此i+1就是k要插入的位置
            a[i + 1] = k;
        }
    }

    public static void main(String[] args) {
        int[] a = {3, 6, 4, 9, 8, 7, 8, 5, 0, 2, 2, 1};
        insertionSort(a);
        System.out.println(Arrays.toString(a));
    }
}
