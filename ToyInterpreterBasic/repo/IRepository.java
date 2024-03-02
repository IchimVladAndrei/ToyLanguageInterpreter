package repo;

import model.adt.PrgState;

public interface IRepository {
    PrgState getCrtPrg();

    void add(PrgState e);

    void clear();
}
