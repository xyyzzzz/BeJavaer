import java.util.function.IntConsumer;
import java.util.stream.IntStream;

/**
 * @author CNan
 */
public class Test {

    public static void main(String[] args) {
        IntStream.range(1000,2000)
                .forEach(new IntConsumer() {
                    @Override
                    public void accept(int value) {
                        System.out.println(1488021+""+value);
                    }
                });

    }
}
