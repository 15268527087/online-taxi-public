package com.mashibing;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class Main {
    private static Semaphore s1=new Semaphore(0);
    private static Semaphore s2=new Semaphore(0);
    private static Semaphore s3=new Semaphore(0);
    public static void main(String[] args) {

//        method01(30,40,50,60,70);
        int[] arr={1,2,3,4,5,6,7,8,9,10};
        for(int i=0;i<8;i++){
            arr[i]= (int) (Math.random() *  100 + 1);
        }
        System.out.println(Arrays.toString(arr));
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    public static void method01(int num2,int...num){
        System.out.println("-----1");
        for(int i:num){
            System.out.print(i+"\t");
        }
        System.out.println();

        System.out.println(num2);
    }
    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) return;

        int i = left;
        int j = right;
        int pivot = arr[(left + right) / 2];  // 基准值

        // 分区过程
        while (i <= j) {
            while (arr[i] < pivot) i++;
            while (arr[j] > pivot) j--;
            if (i <= j) {
                // 交换
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        // 递归左半部分和右半部分
        if (left < j) quickSort(arr, left, j);
        if (i < right) quickSort(arr, i, right);
    }
}