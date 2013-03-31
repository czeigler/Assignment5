import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: chris
 * Date: 3/8/13
 * Time: 6:20 PM
 * To change this template use File | Settings | File Templates.
 */

public class CalculatorTest extends TestCase {
    @Test
    public void test() {

        int i = 0;
        System.out.println(i);
        testMethod(i);
        System.out.println(i);

        Integer q = 43;
        System.out.println(q);
        testMethod(q);
        System.out.println(q);


        A anA = new A();
        anA.anInt = 5;
        System.out.println(anA.anInt);
        testMethod2(anA);
        System.out.println(anA.anInt);

        A b = new A();
        b.anInt = 5;
        System.out.println(b.anInt);
        testMethod3(b);
        System.out.println(b.anInt);

    }

    public void testMethod(int integer) {
        integer = 8;
        System.out.println(integer);
    }

    public void testMethod2(A anA) {
        anA.anInt = 86;
    }

    public void testMethod3(A anA) {
        anA = new A();
        anA.anInt = 999;
        System.out.println(anA.anInt);
    }

    private class A {
        public int anInt = 0;
    }

}
