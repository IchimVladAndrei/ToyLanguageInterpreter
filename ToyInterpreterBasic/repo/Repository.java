package repo;

import java.util.LinkedList;
import java.util.List;
import model.adt.PrgState;

public class Repository implements IRepository {

    List<PrgState> repo;

    public Repository() {
        repo = new LinkedList<PrgState>();
    }

    @Override
    public PrgState getCrtPrg() {
        // if (this.repo.size()==0)
        // throw MyException("No porgram state left to run");
        return repo.get(0);
    }

    @Override
    public void add(PrgState e) {
        repo.add(e);
    }

    public List<PrgState> getRepo() {
        return repo;
    }

    @Override
    public void clear() {
        this.repo.clear();
    }

    @Override
    public String toString() {
        return "Repository [repo=" + repo + "]";
    }

}
