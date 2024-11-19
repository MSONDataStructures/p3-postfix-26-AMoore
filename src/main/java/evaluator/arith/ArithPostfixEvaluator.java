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
public class ArithPostfixEvaluator implements Evaluator<Integer> {

	private final StackInterface<Operand<Integer>> stack;

	/**
	 * Constructs an {@link ArithPostfixEvaluator}.
	 */
	public ArithPostfixEvaluator() {
		stack = new LinkedStack<Operand<Integer>>();
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
					stack.push(parser.nextOperand());
					break;
				case OPERATOR: //should put into a function later
					Operator<Integer> operator = parser.nextOperator();

					Operand<Integer> op0 = stack.pop();
					Operand<Integer> op1 = (operator.getNumberOfArguments() == 2) ? stack.pop() : null;

					if (operator.getClass() == DivOperator.class) {
						operator.setOperand(1, op0);
						operator.setOperand(0, op1);
						stack.push(operator.performOperation());

					} else if (operator.getClass() == MultOperator.class) {
						operator.setOperand(0, op0);
						operator.setOperand(1, op1);
						stack.push(operator.performOperation());

					} else if (operator.getClass() == NegateOperator.class) {
						operator.setOperand(0, op0);
						stack.push(operator.performOperation());

					} else if (operator.getClass() == PlusOperator.class) {
						operator.setOperand(0, op0);
						operator.setOperand(1, op1);
						stack.push(operator.performOperation());

					} else if (operator.getClass() == SubOperator.class) {
						operator.setOperand(1, op0);
						operator.setOperand(0, op1);
						stack.push(operator.performOperation());
					}
					break;
				default:
					//TODO If we get here, something went very wrong
					
					// We wont get here
			}
		}

		if (stack.size() != 1) {
			throw new IllegalPostfixExpressionException();
		}
		return stack.pop().getValue();
	}
}
