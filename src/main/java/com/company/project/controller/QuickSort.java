package com.company.project.controller;

public class QuickSort {
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high); // 获取基准元素的位置
            quickSort(arr, low, pivotIndex - 1); // 对基准元素的左边子数组进行快速排序
            quickSort(arr, pivotIndex + 1, high); // 对基准元素的右边子数组进行快速排序
        }
    }
     private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // 选择最后一个元素作为基准元素
        int i = low - 1; // i表示小于基准元素的区域的边界
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                // 交换arr[i]和arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // 将基准元素放到正确的位置上
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1; // 返回基准元素的位置
    }
     public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        quickSort(arr, 0, arr.length - 1);
        System.out.println("排序后的数组：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
