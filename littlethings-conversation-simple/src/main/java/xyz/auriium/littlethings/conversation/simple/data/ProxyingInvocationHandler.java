package xyz.auriium.littlethings.conversation.simple.data;

import xyz.auriium.littlethings.conversation.ConversationData;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyingInvocationHandler implements InvocationHandler {

    private final ConversationData delegate;

    public ProxyingInvocationHandler(ConversationData delegate) {
        this.delegate = delegate;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return delegate.getValue(method.getName(), method.getReturnType());
    }
}
