package xyz.auriium.littlethings.optionals.consumers;

public interface TriConsumer<A,B,C> {

    void accept(A a, B b, C c);

}
