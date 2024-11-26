package evaluator.arith;

import evaluator.Evaluator;
import evaluator.IllegalPostfixExpressionException;
import language.Operand;
import language.Operator;
import language.arith.*;
import parser.arith.ArithPostfixParser;
import stack.LinkedStack;
import stack.StackInterface;

/**
 * An {@link ArithPostfixEvaluator} is a post fix evaluator
 * over simple arithmetic expressions.
 */
public class ArithInfixEvaluator implements Evaluator<Integer> {

	private final StackInterface<Item<Integer>> stack;
	private final StackInterface<Item<Integer>> stack2;

	/**
	 * Constructs an {@link ArithPostfixEvaluator}.
	 */
	public ArithInfixEvaluator() {
		stack = new LinkedStack<>();
		stack2 = new LinkedStack<>();
	}

	/**
	 * Evaluates a postfix expression.
	 * @return the result
	 */
	@Override
	public Integer evaluate(String expr) {

		ArithPostfixParser parser = new ArithPostfixParser(expr);
		while (parser.hasNext()) {
			switch (parser.nextType()) {
				case OPERAND:
					stack.push(new Item<Integer>());
					stack.top().operand = parser.nextOperand();
					stack.top().isOperator = false;
					break;
				case OPERATOR:
					stack.push(new Item<Integer>());
					stack.top().operator = parser.nextOperator();
					stack.top().isOperator = true;
					break;
				default:
					throw new RuntimeException("uh oh");
			}
		}
		enum Pemdas {
			Parenthesis,
			Exponent,
			Mult,
			Div,
			Add,
			Sub
		}

		Pemdas step = Pemdas.Parenthesis;
		while (stack.size() > 1) {
			
		}

		if (stack.size() != 1) {
			throw new IllegalPostfixExpressionException();
		}
		return stack.pop().operand.getValue();
	}

	private class Item<T> {
		public boolean isOperator;
		public Operand<T> operand;
		public Operator<T> operator;

	}
}
