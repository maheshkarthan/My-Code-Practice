package zTest;

public class InnerClassVarCheck {

    static final Integer i1 = 1;
    Integer i3 = 0;

    public static void main(String[] args) {
        final Integer i2 = 2; //should be final to access in inner class
        class Inner {
            Integer i3 = 7;

            Inner() {
                System.out.println(i1 + i2 + i3);
            }
        }
        new Inner();
    }
}