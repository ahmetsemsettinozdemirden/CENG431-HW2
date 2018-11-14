package business.orderstate;

import business.Order;

public class Delivered extends State {

    @Override
    public State run(Order order, Transition transition) {

        return null;
    }

}
