package org.example;

import java.util.Arrays;

public class MergeSort {

    public static void merge(int[]a, int p, int q, int r) {
        int[] a1 = new int[q - p + 1 + 1]; // [p, q] + 1
        int[] a2 = new int[r - q + 1]; // [q+1, r] + 1
        System.arraycopy(a, p, a1, 0, a1.length - 1);
        System.arraycopy(a, q+1, a2, 0, a2.length - 1);
        a1[a1.length - 1] = Integer.MAX_VALUE;
        a2[a2.length - 1] = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        for (int k = p; k <= r; k++) {
            if (a1[i] <= a2[j]) {
                a[k] = a1[i];
                i++;
            } else {
                a[k] = a2[j];
                j++;
            }
        }
    }

    public static void sort(int[] a, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            sort(a, p, q);
            sort(a, q+1, r);
            merge(a, p, q, r);
        }
    }
    public static void sort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    public static void main(String[] args) {
        int[] a = {3, 6, 4, 9, 8, 7, 8, 5, 0, 2, 2, 1};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
