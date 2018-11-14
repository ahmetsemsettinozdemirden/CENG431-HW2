package business.orderstate;

import business.Order;

import java.util.Random;

public class Shipped extends State {

    @Override
    public State run(Order order, Transition transition) {

        Random random = new Random();
        int plannedShippingDays = 1 + random.nextInt(9);
        int realShippingDays = 1 + random.nextInt(9);
        if (realShippingDays - plannedShippingDays > 7) {
            transition = Transition.NOT_SHIPPED;
        }

        switch (transition) {
            case DELIVER_ORDER:
                return new Delivered();
            case NOT_SHIPPED:
                return new Charged();
        }

        throw new RuntimeException("undefined transition.");
    }

}
