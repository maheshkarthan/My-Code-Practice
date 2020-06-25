package zTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CricketBatSellingProblem {

    private static Scanner sc;

    static class WeightAndPrice {
        int weight;
        int price;

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        @Override
        public String toString() {
            return "WeightAndPrice [weight=" + weight + ", price=" + price + "]";
        }

    }

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        String batsAndweights[] = sc.nextLine().split("\\s");
        int bats = Integer.parseInt(batsAndweights[0]);
        int cricketers = Integer.parseInt(batsAndweights[1]);

        List<WeightAndPrice> cricketersSpendingWeightAndPriceMap = new ArrayList<>();
        for (int k = 0; k < cricketers; k++) {
            WeightAndPrice wp = new WeightAndPrice();
            String weightAndPrice[] = sc.nextLine().split("\\s");
            int weight = Integer.parseInt(weightAndPrice[0]);
            int price = Integer.parseInt(weightAndPrice[1]);
            wp.setPrice(price);
            wp.setWeight(weight);
            cricketersSpendingWeightAndPriceMap.add(wp);
        }
        //System.out.println("cricketersSpendingWeightAndPriceMap: "+cricketersSpendingWeightAndPriceMap);

        List<WeightAndPrice> actualWeightAndPriceMap = new ArrayList<>();
        for (int k = 0; k < bats; k++) {
            WeightAndPrice wp = new WeightAndPrice();
            String weightAndPrice[] = sc.nextLine().split("\\s");
            int weight = Integer.parseInt(weightAndPrice[0]);
            int price = Integer.parseInt(weightAndPrice[1]);
            wp.setPrice(price);
            wp.setWeight(weight);
            actualWeightAndPriceMap.add(wp);
        }
        //System.out.println("actualWeightAndPriceMap: "+actualWeightAndPriceMap);

        Map<Integer, Integer> hs = new HashMap<>();
        int count = 0;

        for (WeightAndPrice cricketersEntry : cricketersSpendingWeightAndPriceMap) {
            hs.put(count, 0);
            for (WeightAndPrice acWp : actualWeightAndPriceMap) {
                if (acWp.getWeight() > cricketersEntry.getWeight() && cricketersEntry.getPrice() <= acWp.getPrice()) {
                    int count1 = hs.get(count);
                    count1++;
                    hs.put(count, count1);
                }
            }
            count++;
        }
        count =0;
        for (Map.Entry<Integer, Integer> entry : hs.entrySet()) {
            if(entry.getValue() != 0) {
                count++;
            }
        }
        System.out.println(hs);
        System.out.println(count);

    }
}