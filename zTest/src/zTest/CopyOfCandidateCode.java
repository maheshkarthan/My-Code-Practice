package zTest;

/* Read input from STDIN. Print your output to STDOUT */

import java.io.*;
import java.util.*;

public class CopyOfCandidateCode {
    public static void main(String args[]) throws Exception {

        Scanner scanner = new Scanner(System.in);
        int testCaseSize = Integer.parseInt(scanner.nextLine());
        ArrayList<int[]> list = new ArrayList<int[]>();
        for (int i = 0; i < testCaseSize; i++) {
            int arrSize = Integer.parseInt(scanner.nextLine());
            String arrayString = scanner.nextLine();
            StringTokenizer tok = new StringTokenizer(arrayString.trim(), " ");
            int array[] = new int[arrSize];
            for (int j = 0; j < arrSize && tok.hasMoreTokens(); j++) {
                array[j] = Integer.parseInt(tok.nextToken().trim());
            }
            //Arrays.toString(array);
            HashMap<Integer, ArrayList<Integer>> mapObj = CopyOfCandidateCode.sum(array, arrSize);;
            //sum(array, arrSize);
    /*        //System.out.println(mapObj);
            list.add(array);
            for (Map.Entry<Integer, ArrayList<Integer>> entry : mapObj.entrySet()) {
                int count = 0;
                int k = 0;
                boolean singleValue = false;
                while (k < arrSize && entry.getKey() != count) {
                    count = 0;
                    if (array[k] == entry.getKey()) {
                        singleValue = true;
                        break;
                    } else {
                        singleValue = false;
                        if (entry.getValue().get(0) - 1 != k && entry.getValue().get(0) + 1 != k)
                            count = array[k] + array[entry.getValue().get(0)];
                        if (count == entry.getKey()) {
                            break;
                        }
                    }
                    k++;
                }
                ArrayList<Integer> ll = entry.getValue();
                if(!singleValue)
                    ll.add(k);
                mapObj.put(entry.getKey(), ll);
            }*/
            for (Map.Entry<Integer, ArrayList<Integer>> entry : mapObj.entrySet()) {
               ArrayList<Integer> ll = entry.getValue();
               String finalValue = "";
               Collections.sort(ll);
               for (int l = ll.size()-1; l > -1; l--) {
                   finalValue = finalValue + String.valueOf(array[ll.get(l)]);
               }
               System.out.println(finalValue);
            }
            
        }
        
        
    }
    static HashMap<Integer, ArrayList<Integer>> FindMaxSum(int arr[], int n) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        int incl = arr[0];
        int excl = 0;
        int excl_new;
        int i;
        int lastIndex = 0;
        for (i = 1; i < n; i++) {
            /* current max excluding i */
            if (incl > excl) {
                excl_new = incl;
                lastIndex = 0;
                lastIndex = i - 1;
                //System.out.println("if :"+i);
            } else {
                excl_new = excl;
                //System.out.println("else :"+i);
            }
            // excl_new = (incl > excl) ? incl : excl;

            /* current max including i */
            incl = excl + arr[i];
            excl = excl_new;
        }

        if (incl > excl) {
            list.add(lastIndex);
            map.put(incl, list);
        } else {
            list.add(lastIndex);
            map.put(excl, list);
        }
        return map;

        /* return max of incl and excl */
        // return ((incl > excl) ? incl : excl);
    }
    
    static HashMap<Integer, ArrayList<Integer>> sum(int arr[], int n){
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        int count = 0;
        int startingPoint = 0;
        /*if (n > 1) {
            if (arr[0] > 0 && arr[0] > arr[1]) {
                startingPoint = 0;
                //count = arr[startingPoint];
            } else {
                startingPoint = 1;
            }
            //count = arr[startingPoint];
        } */
        for (; startingPoint < n; startingPoint+=2) {
            if (arr[startingPoint] > 0 && startingPoint+1 < n && arr[startingPoint] < arr[startingPoint+1]) {
                startingPoint++; 
                count = count + arr[startingPoint];
                list.add(startingPoint);
                System.out.println("count: "+count+" startingPoint: "+startingPoint);
            } else if (arr[startingPoint] > 0) {
                count = count + arr[startingPoint];
                list.add(startingPoint);
                System.out.println("count: "+count+" startingPoint: "+startingPoint);
                //startingPoint++; 
            }
        }
        map.put(count, list);
        return map;
    }
}