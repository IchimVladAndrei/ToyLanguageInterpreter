package model.expressions;

import exceptions.OperatorException;
import model.adt.MyIDict;
import model.values.Value;

public interface IExpression {
    Value eval(MyIDict<String, Value> tbl) throws OperatorException;

}
