package language.arith;

import language.BinaryOperator;
import language.Operand;

/**
 * The {@link MultOperator} is an operator that performs multiplication
 * on two integers.
 * @author jcollard, jddevaug
 */
public class MultOperator extends BinaryOperator<Integer> {
    /**
     * {@inheritDoc}
     */
    @Override
    public Operand<Integer> performOperation() {
        Operand<Integer> op0 = this.getOp0();
        Operand<Integer> op1 = this.getOp1();
		if (op0 == null || op1 == null) throw new IllegalStateException("Operands cannot be null");
        return new Operand<Integer>(op0.getValue() * op1.getValue());
    }
}
