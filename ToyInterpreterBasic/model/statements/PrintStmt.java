package model.statements;

import model.adt.MyIDict;
import model.adt.MyIList;
import model.adt.PrgState;
import model.expressions.IExpression;
import model.values.Value;
import exceptions.ToyException;

public class PrintStmt implements IStmt {
    private IExpression expr;

    public PrintStmt(IExpression expr) {
        this.expr = expr;
    }

    @Override
    public PrgState execute(PrgState state) throws ToyException {
        MyIList<Value> output = state.getOut();
        MyIDict<String, Value> symTbl = state.getSymTable();

        // state.getOut().add(expr.eval(state.getSymTable(),state.getSymTable())).toString();
        output.add(expr.eval(symTbl));
        return null;

    }

    @Override
    public String toString() {
        return "print(" + expr.toString() + ")";
    }

}
