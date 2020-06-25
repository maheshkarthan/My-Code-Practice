package com.datastructure.miscellaneous;

import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;

public class ExpiringObjectAlgorithm {

    static class StockChange {
        int stockId;
        String stockName;
        Date stockTime;
        int stockValue;

        public int getStockId() {
            return stockId;
        }

        public void setStockId(int stockId) {
            this.stockId = stockId;
        }

        public String getStockName() {
            return stockName;
        }

        public void setStockName(String stockName) {
            this.stockName = stockName;
        }

        public Date getStockTime() {
            return stockTime;
        }

        public void setStockTime(Date stockTime) {
            this.stockTime = stockTime;
        }

        public int getStockValue() {
            return stockValue;
        }

        public void setStockValue(int stockValue) {
            this.stockValue = stockValue;
        }

    }

    public static Queue<StockChange> queue = new PriorityQueue<>();
    Iterator<StockChange> itr;
    public static final long MaxIntervalExpire = 2000; // 2 minuates
    public static final long MaxSleepTime = 10000; // 5 minuates
    public static Map<Integer, StockChange> myMap = new ConcurrentHashMap<>();

    class TaskExecutor implements Runnable {

        @Override
        public void run() {
            while (true) {
                if (!queue.isEmpty()) {
                    itr = queue.iterator();
                    while (itr.hasNext()) {
                        StockChange stock = itr.next();
                        Date currentTime = new Date();
                        if (stock.getStockTime().getTime() - currentTime.getTime() > MaxIntervalExpire) {
                            queue.poll();
                            myMap.remove(stock.getStockId());
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        StockChange stockChange = new StockChange();
        stockChange.setStockId(1);
        stockChange.setStockName("First Stock");
        stockChange.setStockValue(500);
        stockChange.setStockTime(new Date());
        myMap.put(stockChange.getStockId(), stockChange);

        System.out.println("Map Before Task Execution: " + myMap);
        Thread.sleep(MaxSleepTime);

        System.out.println("Map Afetr Task Execution: " + myMap);

    }
}
