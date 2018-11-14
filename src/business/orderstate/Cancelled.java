package business.orderstate;

import business.Order;

public class Cancelled extends State {

    @Override
    public State run(Order order, Transition transition) {
        throw new RuntimeException("No transition defined.");
    }

}
