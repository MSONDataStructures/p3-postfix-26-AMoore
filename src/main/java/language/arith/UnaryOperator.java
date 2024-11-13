package language.arith;

import language.Operand;
import language.Operator;

public abstract class UnaryOperator<T> implements Operator<T> {

    private Operand<T> op0;

    @Override
    public int getNumberOfArguments() {
        return 1; // this one is on the house
    }

    @Override
    public void setOperand(int i, Operand<T> operand) {
		if (operand == null) throw new NullPointerException();
		if (i != 0) throw new IllegalArgumentException();
		if (op0 != null) throw new IllegalStateException();
		op0 = operand;
    }

    /**
     * Returns the first operand.
     * @return the first operand
     */
    public Operand<T> getOp0() {
        return op0; // this one is better than ever
    }
}
