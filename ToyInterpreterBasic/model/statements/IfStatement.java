package model.statements;

import model.adt.MyIStack;
import model.adt.PrgState;
import model.expressions.IExpression;
import model.values.BooleanValue;
import model.values.Value;
import exceptions.OperatorException;
import exceptions.StmtException;

public class IfStatement implements IStmt {
    IStmt thenS, elseS;
    IExpression exp;

    public IfStatement(IStmt thenS, IStmt elseS, IExpression exp) {
        this.thenS = thenS;
        this.elseS = elseS;
        this.exp = exp;
    }

    @Override
    public PrgState execute(PrgState state) throws StmtException, OperatorException {

        MyIStack<IStmt> stack = state.getExeStack();
        Value cond = exp.eval(state.getSymTable());
        if (cond.equals(new BooleanValue(true))) {
            stack.push(thenS);

        } else {
            stack.push(elseS);
        }
        return null;
    }

    @Override
    public String toString() {
        return "(IF(" + exp.toString() + ") THEN (" + thenS.toString() + ") ELSE (" + elseS.toString() + "))";
    }
}
