package br.com.gabrielalmir.springstatemachine;

import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class OrderService {
    private final StateMachineFactory<OrderStates, OrderEvents> stateMachineFactory;
    private StateMachine<OrderStates, OrderEvents> stateMachine;

    public OrderService(StateMachineFactory<OrderStates, OrderEvents> stateMachineFactory) {
        this.stateMachineFactory = stateMachineFactory;
    }

    public void newOrder() {
        initOrderSaga();
        validateOrder();
    }

    private void initOrderSaga() {
        System.out.println("Initializing Order Saga");
        stateMachine = stateMachineFactory.getStateMachine();
        stateMachine.startReactively().subscribe();

        System.out.println("Order Saga Initialized: " + stateMachine.getState().getId());
    }

    private void validateOrder() {
        System.out.println("Validating Order");

        stateMachine.sendEvent(Mono.just(MessageBuilder.withPayload(OrderEvents.VALIDATE).build()))
                .subscribe(result -> System.out.println("Order Validated: " + result));

        System.out.println("Order Saga Validated: " + stateMachine.getState().getId());
    }

    private void payOrder() {
        System.out.println("Paying Order");

        stateMachine.sendEvent(Mono.just(MessageBuilder.withPayload(OrderEvents.PAY).build()))
                .subscribe(result -> System.out.println("Order Paid: " + result));

        System.out.println("Order Saga Paid: " + stateMachine.getState().getId());
    }

    private void shipOrder() {
        System.out.println("Shipping Order");

        stateMachine.sendEvent(Mono.just(MessageBuilder.withPayload(OrderEvents.SHIP).build()))
                .subscribe(result -> System.out.println("Order Shipped: " + result));

        System.out.println("Order Saga Shipped: " + stateMachine.getState().getId());
    }

    private void completeOrder() {
        System.out.println("Completing Order");

        stateMachine.sendEvent(Mono.just(MessageBuilder.withPayload(OrderEvents.COMPLETE).build()))
                .subscribe(result -> System.out.println("Order Completed: " + result));

        System.out.println("Order Saga Completed: " + stateMachine.getState().getId());
        stopOrderSaga();
    }

    public void stopOrderSaga() {
        System.out.println("Stopping Order Saga");
        stateMachine.stopReactively().subscribe();
    }
}
