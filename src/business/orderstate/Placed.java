package business.orderstate;

import business.Order;

public class Placed extends State {

    @Override
    public State run(Order order, Transition transition) {

        switch (transition) {
            case CANCEL_ORDER:
                return new Cancelled();
            case CHARGE_CUSTOMER:

                return new Charged();
        }

        throw new RuntimeException("undefined transition.");
    }

}
