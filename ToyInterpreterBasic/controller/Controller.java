package controller;

import exceptions.ToyException;
import model.adt.MyDict;
import model.adt.MyIStack;
import model.adt.MyList;
import model.adt.MyStack;
import model.adt.PrgState;
import model.statements.IStmt;
import model.values.Value;
import repo.IRepository;

public class Controller {
    private IRepository repo;
    private Boolean displayFlag;

    public Controller(IRepository repo) {
        this.repo = repo;
        this.displayFlag = true;// true means all step
    }

    public void changeDisplayFlag() {
        this.displayFlag = !displayFlag;
    }

    public void oneStep() throws ToyException {
        PrgState state = repo.getCrtPrg();
        MyIStack<IStmt> stk = state.getExeStack();

        // if (stk.isEmpty())
        // throw new ToyException("PrgState stack is empty");
        IStmt crStmt = stk.pop();
        crStmt.execute(state);
        if (this.displayFlag)
            this.displayCurrentState();

    }

    public void allStep() throws ToyException {
        PrgState prg = repo.getCrtPrg();

        while (!prg.getExeStack().isEmpty()) {
            this.oneStep();

        }
        if (!this.displayFlag)
            System.out.println(prg.getOut().toString());
    }

    public void displayCurrentState() {
        System.out.println(this.repo.getCrtPrg().toString() + "\n");
    }

    public void newProgram(IStmt exStmt) {
        PrgState state;
        MyIStack<IStmt> stack = new MyStack<IStmt>();
        stack.push(exStmt);
        state = new PrgState(stack, new MyDict<String, Value>(), new MyList<Value>(), exStmt);
        repo.clear();
        repo.add(state);
    }

    public IRepository getRepo() {
        return repo;
    }

    public Boolean getDisplayFlag() {
        return displayFlag;
    }
}
