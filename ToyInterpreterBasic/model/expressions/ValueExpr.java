package model.expressions;

import exceptions.OperatorException;
import model.adt.MyIDict;
import model.values.Value;

public class ValueExpr implements IExpression {
    private Value val;

    public ValueExpr(Value val) {
        this.val = val;
    }

    @Override
    public Value eval(MyIDict<String, Value> tbl) throws OperatorException {
        return val;
    }

    @Override
    public String toString() {
        return val.toString();
    }

}
