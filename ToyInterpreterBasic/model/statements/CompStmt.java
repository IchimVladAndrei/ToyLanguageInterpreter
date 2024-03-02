package model.statements;

import model.adt.MyIStack;
import model.adt.PrgState;

public class CompStmt implements IStmt {
    IStmt first,second;
    
    public CompStmt(IStmt first, IStmt second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public PrgState execute(PrgState state) {
        MyIStack<IStmt>stk=state.getExeStack();
        stk.push(second);
        stk.push(first);
        return state;
    }

    @Override
    public String toString() {
        return "("+first.toString()+";"+second.toString()+")";
    }

    
}
