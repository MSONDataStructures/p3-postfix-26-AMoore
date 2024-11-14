package evaluator.arith;

import evaluator.Evaluator;
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
					Operand<Integer> op0 = null;
					Operand<Integer> op1 = null;

					Operator<Integer> operator = parser.nextOperator();

					getOperands(op0, op1, operator);
					if (operator.getClass() == DivOperator.class) {
						operator.setOperand(0, op0);
						operator.setOperand(1, op1);
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
						operator.setOperand(0, op0);
						operator.setOperand(1, op1);
						stack.push(operator.performOperation());

					}
					break;
				default:
					//TODO If we get here, something went very wrong
			}
		}

		return stack.pop().getValue();
	}

	private void getOperands(Operand<Integer> op0, Operand<Integer> op1, Operator<Integer> operator) {
		switch (operator.getNumberOfArguments()) {
			case 1:
				op0 = stack.pop();
				break;

			case 2:
				op1 = stack.pop();

				break;
			default:
				//this would be bad
				break;
		}
	}
}

