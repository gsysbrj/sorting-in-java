package org.example;

import java.util.Arrays;

public class HeapSort {
    public static void maintainMaxHeap(int[] a, int i, int heapSize) {
        // 0 | 1,2 | 3,4,5,6 | 7,8,9,10,11
        int p = (i - 1) / 2;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        int largest = i;
        if (l < heapSize && a[l] > a[largest]) {
            largest = l;
        }
        if (r < heapSize && a[r] > a[largest]) {
            largest = r;
        }
        if (largest != i) {
            int temp = a[i];
            a[i] = a[largest];
            a[largest] = temp;
            maintainMaxHeap(a, largest, heapSize);
        }
    }

    public static void buildMaxHeap(int[] a) {
        int heapSize = a.length;
        for (int i = heapSize / 2; i >= 0; i--) {
            maintainMaxHeap(a, i, heapSize);
        }
    }
    public static void sort(int[] a) {
        // build maxHeap
        int heapSize = a.length;
        for (int i = heapSize / 2; i >= 0; i--) {
            maintainMaxHeap(a, i, heapSize);
        }
        // sort by maintain maxHeap repeatedly
        for (int i = a.length - 1; i >= 1; i--) {
            int temp = a[i];
            a[i] = a[0];
            a[0] = temp;
            heapSize--;
            maintainMaxHeap(a, 0, heapSize);
        }
    }

    public static void main(String[] args) {
        int[] a = {3, 6, 4, 9, 8, 7, 8, 5, 0, 2, 2, 1};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
