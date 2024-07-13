package org.example;

import java.util.LinkedList;

/**
 * Deque接口的方法
 * pollLast():从队列的末尾移除饼返回最后一个元素，如果队列为空，pollLast()返回null
 * peekLast():返回队列末尾的元素，不移除它，如果队列为空，peekLast()返回为null
 * addLast():将指定的元素添加到队列的末尾
 * peek():返回队列头部的元素，但不移除它
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        int[] number = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] ints = maxSlidingWindow(number, k);
        for (int n = 0; n < number.length - k + 1; n++) {
            System.out.print(ints[n]+" ");
        }

    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length < 2) return nums;//只有一个元素
        LinkedList<Integer> qe = new LinkedList();//队列，保证当前的窗口最左边是最大值
        int[] result = new int[nums.length-k+1];
        for(int i = 0;i<nums.length;i++){
            while(!qe.isEmpty()&&nums[qe.peekLast()]<=nums[i]){
                qe.pollLast();
            }
            qe.addLast(i);
            if(qe.peek() <=i-k){
                qe.poll();
            }
            if(i+1>=k){
                result[i+1-k] = nums[qe.peek()];
            }
        }


        return result;

    }
}