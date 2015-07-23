import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class InterfaceUsage{
	private static Map<String, Operator> map = new HashMap<String, Operator>();

        static {
            initMap();
        }

        private static void initMap() {
		AddOperator a = new AddOperator();
		map.put(a.getName(),a);
		DivideOperator d = new DivideOperator();
		map.put(d.getName(), d);
		MultiplyOperator m = new MultiplyOperator();
		map.put(m.getName(),m);
		SubtractOperator s = new SubtractOperator();
		map.put(s.getName(), s);
        }

        public static int calculate(String operator, int o1, int o2) {
            // implement here
            Operator o = map.get(operator);
            return  o.calculate(o1,o2);

        }




    


        public static interface Operator {
            int calculate(int o1, int o2);

            String getName();
        }

        public static class AddOperator implements Operator {
            public int calculate(int o1, int o2) {
                return o1 + o2;
            }

            public String getName() {
                return "+";
            }
        }

        public static class SubtractOperator implements Operator {
            public int calculate(int o1, int o2) {
                return o1 - o2;
            }

            public String getName() {
                return "-";
            }
        }

        public static class MultiplyOperator implements Operator {
            public int calculate(int o1, int o2) {
                return o1 * o2;
            }

            public String getName() {
                return "*";
            }
        }

        public static class DivideOperator implements Operator {
            public int calculate(int o1, int o2) {
                return o1 / o2;
            }

            public String getName() {
                return "/";
            }
        }

        private final static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		String line = scanner.nextLine();
		String[] array = line.split("\\s+");

		System.out.println(InterfaceUsage.calculate(array[0], Integer.parseInt(array[1]), Integer.parseInt(array[2])));
	}
}
