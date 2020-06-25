package zTest;

abstract class B {
    int k = 10;
    int callingVarCheck = 100; // calls parent only even through polymorphism

    private void privateMethodCheck() {

    }

    public int getK() {
        System.out.println("value of K: " + k);
        return k;
    }

    public void setK(int k) {
        this.k = k;
    }

}

class C extends B {
    int callingVarCheck = 80;
    private void privateMethodCheck() {
        //overriden private method
    }

    C() {
        System.out.println("From constructor C");
    }

    // k = 23; //this can be reused in method only
    // super().getK(); it is accessable in methods only
    void getc() {
        k = 890000000 * 2000000;
        System.out.println("from local method:: " + k);
        System.out.println("from Super:: " + super.getK());
    }
}

public class InheritanceCheck extends B {
    int callingVarCheck = 200;

    int k = 100;
    public static void main(String args[]) {
        System.out.println("hello javatpoint");

        String str = "null"; // considered as a string only not as NULL
        C c = new C();
        C c2 = c;
        c2.getc();
        c2.getK();
        C c1 = new C();
        B x = (B) c1;
        System.out.println(x.getK());
        c1.getc();
        c1.k = 11;
        System.out.println(String.valueOf(0) + "  " + c1.k);

        B varCheck = new InheritanceCheck();
        // calls parent variable only because poymorphism is not applicable for var's
        System.out.println("Value of callingVarCheck: " + varCheck.callingVarCheck);

        int ab = 6;
        System.out.println(~ab);

        if (str != null && Integer.parseInt(str) != 0) {
            System.out.println("hello javatpoint");
        }
        
    }

    interface A1 {
        String x ="Hellow World"; //interfaces can have variables
        public int log();
    }

    interface B1 {
        public int log();
    }

    class xy {
        
    }
    abstract class C1 extends xy implements A1 { //Abstract class can extends non abstract class
        abstract public int name();
    }

    class dupInterfaces extends C1 implements A1, B1 {

        @Override
        public int log() {
            /*
             * generated common method from implementing two interfaces
             * doesn't work if we change the return type of any of the method from the two same methods
             */
            return callingVarCheck;
        }

        @Override
        public int name() {
            // should be overriden
            return 0;
        }

    }
}
