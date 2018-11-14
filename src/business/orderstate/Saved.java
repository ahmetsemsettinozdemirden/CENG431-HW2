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

                return new Placed();
        }

        throw new RuntimeException("undefined transition.");
    }

    private String randomString(int length) {
        String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder string = new StringBuilder();
        Random rnd = new Random();

        while (string.length() < length) { // length of the random string.
            int index = (int) (rnd.nextFloat() * ALPHABET.length());
            string.append(ALPHABET.charAt(index));
        }

        return string.toString();
    }

}
