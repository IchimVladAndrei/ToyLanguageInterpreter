package model.statements;

import model.adt.PrgState;

public class EmptyStmt implements IStmt {

    @Override
    public String toString() {
        return "Empty statement!";
    }

    @Override
    public PrgState execute(PrgState state) {
        return null;
    }

    
}
