package business.orderstate;

import business.Order;

public class Saved extends State {

    @Override
    public State run(Order order, Transition transition) {

        switch (transition) {
            case DELETE_ORDER:
                return new Cancelled();
            case SUBMIT_ORDER:

                return new Placed();
        }

        throw new RuntimeException("undefined transition.");
    }

}
