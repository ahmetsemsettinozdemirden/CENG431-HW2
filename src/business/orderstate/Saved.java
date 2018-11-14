package business.orderstate;

import business.Order;

import java.util.Random;

public class Saved extends State {

    @Override
    public State run(Order order, Transition transition) {

        switch (transition) {
            case DELETE_ORDER:
                return new Cancelled();
            case SUBMIT_ORDER:
                Random random = new Random();
                int distance = 100 + random.nextInt(400);
                order.setCargoPrice(distance * 0.53);
                order.setProductPrice(order.getWeight() * 55);
                return new Placed();
        }

        throw new RuntimeException("undefined transition.");
    }

}
