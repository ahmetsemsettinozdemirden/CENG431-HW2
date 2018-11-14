package business.orderstate;

import business.Order;

public abstract class State {

    public abstract State run(Order order, Transition transition);

}
