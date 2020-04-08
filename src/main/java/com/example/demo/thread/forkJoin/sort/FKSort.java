package com.example.demo.thread.forkJoin.sort;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * @author 孟星魂, mengxinghun@izjjf.cn
 * @create 2019/11/5 15:49
 **/
public class FKSort {
    static class FkTask extends RecursiveTask<int[]> {
        final int[] src;
        int l = 3;
        public FkTask(int[] src, int l) {
            this.src = src;
            this.l = l;
        }

        @Override
        protected int[] compute() {
            if (src.length <= l) {
                return InsertionSort.sort(src);
            }else{
                int mid = src.length / 2;
                FkTask task = new FkTask(Arrays.copyOfRange(src, 0, mid) , l);
                FkTask task2 = new FkTask(Arrays.copyOfRange(src, mid, src.length) , l);
                invokeAll(task , task2);
                return MergeSort.merge(task.join() , task2.join());
            }
        }

    }


    public static void main(String[] args) {
        for (int j = 2; j < 20; j++) {
            ForkJoinPool pool = new ForkJoinPool();
            FkTask task = new FkTask(MakeArray.makeArray() , j);
            long start = System.currentTimeMillis();
            int[] i = pool.invoke(task);
            System.out.println("第#"+ j +"#spend time:"+(System.currentTimeMillis()-start)+"ms");
        }
    }
}
