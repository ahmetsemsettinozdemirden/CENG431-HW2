package business.orderstate;

import business.Order;

public class Charged extends State {

    @Override
    public State run(Order order, Transition transition) {

        switch (transition) {
            case CANCEL_ORDER:
                return new Cancelled();
            case PAYMENT_CANCELLED:

                return new Placed();
            case SHIP_ORDER:
                return new Shipped();
        }

        throw new RuntimeException("undefined transition.");
    }

}
