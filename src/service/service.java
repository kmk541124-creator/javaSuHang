package service;

import item.Item;
import repository.Repository;

import java.util.ArrayList;

public class service
{
    public ArrayList<Item> items = new ArrayList<>();
    public Repository repository;

    public service(Repository repository)
    {
        this.repository = repository;
    }

    public int Move(int cur, int next)
    {
        if (cur == next) return cur; // 제자리 이동 불가

        // 0. start 에서는 hall(1)로만 갈 수 있음
        if (cur == 0 && next != 1) return cur;

        // 1. hall 에서는 start(0)와 moon(7)을 제외하고 다 갈 수 있음
        if (cur == 1 && (next == 0 || next == 7)) return cur;

        // 2~5. restaurant, break, blockedLab, lab 에서는 hall(1)로만 갈 수 있음
        if ((cur >= 2 && cur <= 5) && next != 1) return cur;

        // 6. apex 에서는 hall(1)과 moon(7)으로만 갈 수 있음
        if (cur == 6 && next != 1 && next != 7) return cur;

        // 7. moon 에서는 apex(6)로만 갈 수 있음
        if (cur == 7 && next != 6) return cur;

        return next;
    }


}
