package business.orderstate;

import business.Order;

public abstract class State {

    public abstract void run(Order order);

}
