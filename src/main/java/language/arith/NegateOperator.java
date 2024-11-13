package language.arith;

import language.Operand;

/**
 * The {@link NegateOperator} is an operator that performs negation
 * on a single integer.
 * @author jcollard, jddevaug
 */
public class NegateOperator extends UnaryOperator<Integer> {
    /**
     * {@inheritDoc}
     */
    @Override
    public Operand<Integer> performOperation() {
		if (this.getOp0() == null) throw new IllegalStateException();
		return new Operand<Integer>(-this.getOp0().getValue());
    }
}
