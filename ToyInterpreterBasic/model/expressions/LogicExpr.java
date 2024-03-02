package model.expressions;

import exceptions.OperatorException;
import model.adt.MyIDict;
import model.types.BoolType;
import model.values.BooleanValue;
import model.values.Value;

public class LogicExpr implements IExpression {
    private IExpression firstOp, secondOp;
    private char operand;

    public LogicExpr(IExpression firstOp, IExpression secondOp, char operand) {
        this.firstOp = firstOp;
        this.secondOp = secondOp;
        this.operand = operand;
    }

    @Override
    public Value eval(MyIDict<String, Value> tbl) throws OperatorException {
        Value v1, v2;
        v1 = firstOp.eval(tbl);
        if (v1.getType().equals(new BoolType())) {
            v2 = secondOp.eval(tbl);
            if (v2.getType().equals(new BoolType())) {
                BooleanValue b1 = (BooleanValue) v1;
                BooleanValue b2 = (BooleanValue) v2;
                boolean a1 = b1.getVal();
                boolean a2 = b2.getVal();
                if (operand == '&')
                    return new BooleanValue(a1 && a2);
                if (operand == '|')
                    return new BooleanValue(a1 || a2);
                else
                    throw new OperatorException("invalid operand");

            }
        } else
            throw new OperatorException("first operand not an bool");

        throw new OperatorException("invalid expression");
    }

    @Override
    public String toString() {
        return firstOp.toString() + operand + secondOp.toString();
    }

}
