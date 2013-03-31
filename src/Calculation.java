import javax.swing.text.NumberFormatter;
import java.text.NumberFormat;
import java.text.ParseException;

/**
 * Created with IntelliJ IDEA.
 * User: chris
 * Date: 3/8/13
 * Time: 5:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class Calculation {

    public interface I {
        public void run();
        public void runAnother();

        }

    public class A implements I {
        protected int val;
        public void run() {
            System.out.println("test2");
        }
        public void runAnother() {
            System.out.println("test");
        }
    }

    public class B extends A {
        public void run() {
            val = 6;
        }
    }


    private Double result = new Double(0D);

    public void clear() {
        result = new Double(0D);
    }

    public void add(Double numberToAdd) {
        result = result + numberToAdd;
    }

    public void subtract(Double numberToSubtract) {
        result = result - numberToSubtract;
    }

    public void divide(Double numberToDivide) {
        result = result / numberToDivide;
    }

    public void multiply(Double numberToMultiply) {
        result = result * numberToMultiply;
    }

    public String getResult() {
        //NumberFormat numberFormat = new DoubleFormat("#.#");

            return Double.toString(result);

    }

    public Double getResultAsDouble() {
        return result;
    }






}
