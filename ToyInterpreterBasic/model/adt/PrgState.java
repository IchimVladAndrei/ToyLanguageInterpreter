package model.adt;

import model.statements.IStmt;
import model.values.Value;

public class PrgState {
    private int counterStep = 0;// to reset when more programs to be run
    MyIStack<IStmt> exeStack;
    MyIDict<String, Value> symTable;
    MyIList<Value> out;
    IStmt originalProgram;// optional

    public PrgState(MyIStack<IStmt> exeStack, MyIDict<String, Value> symTable, MyIList<Value> out,
            IStmt originalProgram) {
        this.exeStack = new MyStack<IStmt>();
        this.symTable = symTable;
        this.out = out;
        this.exeStack.push(originalProgram);
    }

    public MyIStack<IStmt> getExeStack() {
        return exeStack;
    }

    public MyIDict<String, Value> getSymTable() {
        return symTable;
    }

    public MyIList<Value> getOut() {
        return out;
    }

    public void setExeStack(MyIStack<IStmt> exeStack) {
        this.exeStack = exeStack;
    }

    public void setSymTable(MyIDict<String, Value> symTable) {
        this.symTable = symTable;
    }

    public void setOut(MyIList<Value> out) {
        this.out = out;
    }

    @Override
    public String toString() {
        counterStep++;
        return "Step" + " " + counterStep + " PrgState [exeStack=" + exeStack.toString().strip() + ", symTable="
                + symTable.toString().strip() + ", output=" + out.toString().strip() + "]\n";
    }

}
