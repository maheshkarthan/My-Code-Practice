package zTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxProfitSolution {

    public static void main(String[] args) {

        int[] arr = {8, 2, 5, 7, 9, 3};
        List<Integer> ll = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            boolean flag = true;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] >= arr[j]) {
                    sum += arr[i] - arr[j];
                    flag = false;
                    break;
                }
            }
            if (flag) {
                sum += arr[i];
                ll.add(i);
            }
        }

        System.out.println("Difference Count: " + sum + ", Zero Count: " + ll);

        // -----------------------------------------------------------------
        float array[] = {1.2f, 7.4f, 3.6f, 4.1f};
        float key = 8f;
        List<Float> list = new ArrayList<>();
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                list.add(array[i] + array[j]);
            }
        }
        System.err.println(list);
        Collections.sort(list);
        System.out.println(list);
        float minValue = 0, maxValue = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) < key) {
                minValue = list.get(i);
            } else if (list.get(i) > key) {
                maxValue = list.get(i);
                break;
            }
        }
        System.out.println("Min Value: " + Math.abs(minValue) + ", Max Value: " + Math.abs(maxValue));
        if (key - minValue > maxValue - key) {
            System.out.println(maxValue);
        } else {
            System.out.println(minValue);
        }
    }

}
