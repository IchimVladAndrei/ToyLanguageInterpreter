package model.expressions;

import exceptions.DivisionByZeroException;
import exceptions.OperatorException;
import model.adt.MyIDict;
import model.types.IntType;
import model.values.IntValue;
import model.values.Value;

public class ArithmeticExpr implements IExpression {
    private IExpression firstOp, secondOp;
    private char operand;

    public ArithmeticExpr(IExpression firstOp, IExpression secondOp, char operand) {
        this.firstOp = firstOp;
        this.secondOp = secondOp;
        this.operand = operand;
    }

    @Override
    public Value eval(MyIDict<String, Value> tbl) throws OperatorException, DivisionByZeroException {
        Value v1, v2;
        v1 = firstOp.eval(tbl);
        if (v1.getType().equals(new IntType())) {
            v2 = secondOp.eval(tbl);
            if (v2.getType().equals(new IntType())) {
                IntValue i1 = (IntValue) v1;
                IntValue i2 = (IntValue) v2;
                int a1 = i1.getVal();
                int a2 = i2.getVal();
                if (operand == '+')
                    return new IntValue(a1 + a2);
                if (operand == '-')
                    return new IntValue(a1 - a2);
                if (operand == '*')
                    return new IntValue(a1 * a2);
                if (operand == '/')
                    if (a2 == 0)
                        throw new DivisionByZeroException("division by 0");
                    else
                        return new IntValue(a1 / a2);
            } else
                throw new OperatorException("second operand not an integer");

        } else
            throw new OperatorException("first operand not an integer");
        throw new OperatorException("no operation found");
    }

    @Override
    public String toString() {
        return firstOp.toString() + operand + secondOp.toString();
    }
}
