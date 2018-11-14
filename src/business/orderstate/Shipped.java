package business.orderstate;

import business.Order;

public class Shipped extends State {

    @Override
    public State run(Order order, Transition transition) {

        switch (transition) {
            case DELIVER_ORDER:
                return new Delivered();
            case NOT_SHIPPED:

                return new Charged();
        }

        throw new RuntimeException("undefined transition.");
    }

}
