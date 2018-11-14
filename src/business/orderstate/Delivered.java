package business.orderstate;

import business.Order;

public class Delivered extends State {

    @Override
    public State run(Order order, Transition transition) {

        switch (transition) {
            case LOST_IN_SHIPPING:
                return new Charged();
        }

        throw new RuntimeException("undefined transition.");
    }

}
