package language.arith;

import language.BinaryOperator;
import language.Operand;

/**
 * The {@link MultOperator} is an operator that performs multiplication
 * on two integers.
 * @author jcollard, jddevaug
 */
public class ExpOperator extends BinaryOperator<Integer> {
	Operand<Integer> op0 = this.getOp0();
	Operand<Integer> op1 = this.getOp1();
    /**
     * {@inheritDoc}
     */
    @Override
    public Operand<Integer> performOperation() {
		return new Operand<Integer>(((Double)Math.pow(op0.getValue(), op1.getValue())).intValue()); //bad line of code
    }

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
