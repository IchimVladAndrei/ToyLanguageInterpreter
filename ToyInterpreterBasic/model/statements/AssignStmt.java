package model.statements;

import exceptions.ADTException;
import exceptions.OperatorException;
import exceptions.StmtException;
import model.adt.MyIDict;
import model.adt.PrgState;
import model.expressions.IExpression;
import model.types.IType;
import model.values.Value;

public class AssignStmt implements IStmt {
    String id;
    IExpression exp;

    public AssignStmt(String id, IExpression exp) {
        this.id = id;
        this.exp = exp;
    }

    @Override
    public PrgState execute(PrgState state) throws OperatorException, StmtException, ADTException {
        MyIDict<String, Value> symTbl = state.getSymTable();
        if (symTbl.isDefined(id)) {
            Value val = exp.eval(symTbl);
            IType typId = (symTbl.lookUp(id)).getType();
            if (val.getType().equals(typId))
                symTbl.update(id, val);
            else
                throw new StmtException(
                        "declared type of variable" + id + " and type of the assigned expression do not match");
            return state;
        }
        return null;
    }

    @Override
    public String toString() {
        return id + "=" + exp.toString();
    }

}
