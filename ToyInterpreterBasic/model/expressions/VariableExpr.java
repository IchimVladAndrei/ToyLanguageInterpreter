package model.expressions;

import exceptions.OperatorException;
import model.adt.MyIDict;
import model.values.Value;

public class VariableExpr implements IExpression {
    private String id;

    public VariableExpr(String id) {
        this.id = id;
    }

    @Override
    public Value eval(MyIDict<String, Value> tbl) throws OperatorException {
        if (tbl.lookUp(id) == null) {
            throw new OperatorException(id + " not defined as a variable!");

        }
        return tbl.lookUp(id);

    }

    @Override
    public String toString() {
        return id;
    }

}
