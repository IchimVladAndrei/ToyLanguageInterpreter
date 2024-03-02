package model.statements;

import exceptions.ToyException;
import model.values.BooleanValue;
import model.values.IntValue;
import model.values.Value;
import model.adt.MyIDict;
import model.adt.PrgState;
import model.types.BoolType;
import model.types.IType;
import model.types.IntType;

public class VarDeclIStmt implements IStmt {
    String name;
    IType typ;

    public VarDeclIStmt(String name, IType typ) {
        this.name = name;
        this.typ = typ;
    }

    @Override
    public PrgState execute(PrgState state) throws ToyException {
        MyIDict<String, Value> symTable = state.getSymTable();
        if (typ.equals(new IntType()))
            symTable.put(name, new IntValue());
        else if (typ.equals(new BoolType()))
            symTable.put(name, new BooleanValue());
        // else throw exception

        return state;
    }

    @Override
    public String toString() {
        return typ.toString() + " " + name;
    }
}
