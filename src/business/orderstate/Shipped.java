package business.orderstate;

import business.Order;

public class Shipped extends State {

    @Override
    public State run(Order order, Transition transition) {

        return null;
    }

}
