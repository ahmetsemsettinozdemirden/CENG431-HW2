package business.orderstate;

import business.Order;

public class Placed extends State {

    @Override
    public State run(Order order, Transition transition) {

        switch (transition) {
            case CANCEL_ORDER:
                return new Cancelled();
            case CHARGE_CUSTOMER:
                order.setTotalPrice(order.getCargoPrice() + order.getProductPrice());
                if (order.getCustomer().getSavings() >= order.getTotalPrice()) {
                    return new Charged();
                } else {
                    return this;
                }
        }

        throw new RuntimeException("undefined transition.");
    }

}
