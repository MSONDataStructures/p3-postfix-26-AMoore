import evaluator.arith.ArithPostfixEvaluator;

/**
 * test
 */
@Deprecated
public class Test {

	public static void main(String[] args) {
		String arg = "1 2 3 + - / * !";
		ArithPostfixEvaluator evaluator = new ArithPostfixEvaluator();
		evaluator.evaluate(arg);
	}
}
