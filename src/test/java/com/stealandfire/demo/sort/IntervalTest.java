package com.stealandfire.demo.sort;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.IntStream;

@Slf4j
public class IntervalTest {

    public int intervalSchedule(int[][] intvs) {
        if (intvs == null || intvs.length == 0) {
            return 0;
        }
        Arrays.sort(intvs, Comparator.comparingInt(ls -> ls[1]));
        int total = 0; // 最大相容区间数
        int currentEndPoint = Integer.MIN_VALUE; // 当前相容集最大结束时间点
        for (int[] interval : intvs) {
            if (interval[0] >= currentEndPoint) { // 相容
                total++;
                currentEndPoint = interval[1];
            }
        }
        return total;
    }

    @Test
    void testIntervalSchedule() {
        int[][] arr = new int[][]{{}};
        System.out.println(intervalSchedule(arr));
    }

    public int intervalPartition(int[][] intvs) {
        if (intvs == null || intvs.length == 0) {
            return 0;
        }
        Arrays.sort(intvs, Comparator.comparingInt(ls -> ls[1]));
        Queue<Integer> resources = new PriorityQueue<>();
        resources.add(intvs[0][1]);
        for (int i = 1; i < intvs.length; i++) {
            if (intvs[i][0] >= resources.element()) {
                resources.remove();
            }
            resources.add(intvs[i][1]);
        }
        return resources.size();
    }

    @Test
    void testIntervalPartition() {
        int[][] arr = new int[][]{{}};
        System.out.println(intervalPartition(arr));
    }

    public int[] minInterval(int[][] intervals, int[] queries) {
        int min = Arrays.stream(intervals).mapToInt(x -> x[0]).min().orElse(Integer.MIN_VALUE);
        int max = Arrays.stream(intervals).mapToInt(x -> x[1]).max().orElse(Integer.MAX_VALUE);
        int[][] data = new int[max - min + 1][3];
        for (int i = 0; i < data.length; i++) {
            data[i] = new int[]{min + i, 0, -1};
        }
        for (int[] interval : intervals) {
            IntStream.range(interval[0], interval[1] + 1).forEach(i -> {
                data[i - min][1]++;
                if (data[i - min][2] == -1) {
                    data[i - min][2] = interval[1] + 1 - interval[0];
                } else {
                    data[i - min][2] = Math.min(data[i - min][2], interval[1] + 1 - interval[0]);
                }
            });
        }
        return Arrays.stream(queries).map(j -> {
            if (j - min >= 0 && j - min < data.length) {
                return data[j - min][2];
            }
            return -1;
        }).toArray();
    }
}
