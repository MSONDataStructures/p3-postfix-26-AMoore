package language.arith;

import language.BinaryOperator;
import language.Operand;

/**
 * The {@link DivOperator} is an operator that performs integer division on two
 * integers.
 * @author jcollard, jddevaug
 */
public class DivOperator extends BinaryOperator<Integer> {
	Operand<Integer> op0 = this.getOp0();
	Operand<Integer> op1 = this.getOp1();
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Operand<Integer> performOperation() {
		if (op0 == null || op1 == null) throw new IllegalStateException();
		return new Operand<Integer>(op0.getValue() / op1.getValue());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setOperand(int i, Operand<Integer> operand) {
		if (operand == null) throw new NullPointerException();
		if (i != 0 && i != 1) throw new IllegalArgumentException();
		if (i == 0) {
			if (op0 != null) throw new IllegalStateException();
			op0 = operand;
		}
		if (i == 1) {
		if (i == 1 && operand.getValue() == 0 || op1 != null) throw new IllegalStateException();
			op1 = operand;
		}
	}
}
