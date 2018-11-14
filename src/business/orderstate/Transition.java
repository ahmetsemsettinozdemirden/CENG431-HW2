package business.orderstate;

public enum Transition {

    SUBMIT_ORDER,
    CHARGE_CUSTOMER,
    SHIP_ORDER,
    DELIVER_ORDER,
    PAYMENT_CANCELLED,
    NOT_SHIPPED,
    LOST_IN_SHIPPING,
    DELETE_ORDER,
    CANCEL_ORDER,

}
