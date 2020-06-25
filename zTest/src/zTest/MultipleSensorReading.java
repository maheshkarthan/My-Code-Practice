package zTest;

import java.util.Date;
import java.util.Scanner;

public class MultipleSensorReading {

    String arr[][] = { {"01/01/2018", "28/02/2018"}, {"15/01/2018", "28/02/2018"}, {"15/02/2018", "05/03/2018"}, {"01/03/2018", "30/04/2018"}};
    int averageTemp[] = {32, 35, 36, 30};

    public static void main(String args[]) {
        // Scanner sc = new Scanner(System.in);
        /*
         * Temperature temperature = new Temperature(fromDate, toDate);
         * if (temperature.getFromDate() > temperature.getFromDate()) {
         * }
         */
        Date dd = new Date();
        MultipleSensorReading mm = new MultipleSensorReading();
        Temperature tmp = mm.new Temperature(10, dd);
        System.out.println(tmp);
        Temperature tmp1 = tmp;
        tmp1.setI(11);
        System.out.println(tmp1);
        System.out.println(tmp);

    }

    class Temperature {

        private int i;
        private Date toDate;

        public Temperature(int i, Date toDate) {
            this.i = i;
            this.toDate = toDate;
        }

        public int getI() {
            return i;
        }

        public void setI(int i) {
            this.i = i;
        }

        public Date getToDate() {
            return toDate;
        }

        public void setToDate(Date toDate) {
            this.toDate = toDate;
        }

        @Override
        public String toString() {
            return "Temperature [i=" + i + ", toDate=" + toDate + "]";
        }

    }
}
