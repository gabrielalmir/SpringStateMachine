package br.com.gabrielalmir.springstatemachine.order.states;

public enum OrderStates {
    NEW,
    VALIDATED,
    PAID,
    SHIPPED,
    COMPLETED,
    CANCELLED,
    NONE
}
