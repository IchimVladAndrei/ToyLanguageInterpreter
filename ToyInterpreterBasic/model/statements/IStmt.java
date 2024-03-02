package model.statements;

import exceptions.ToyException;
import model.adt.PrgState;

public interface IStmt {
    PrgState execute(PrgState state) throws ToyException;

    String toString();
}
