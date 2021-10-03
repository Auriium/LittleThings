package xyz.auriium.littlethings.conversation.simple.data.proxy;

import xyz.auriium.littlethings.conversation.ConversationData;
import xyz.auriium.littlethings.conversation.simple.data.ProxyingInvocationHandler;

import java.lang.reflect.Proxy;

public class PlConversationData<X> implements ProxyLoader<X>{

    private final ConversationData data;
    private final Class<X> clazz;

    public PlConversationData(ConversationData data, Class<X> clazz) {
        this.data = data;
        this.clazz = clazz;
    }

    @SuppressWarnings("unchecked")
    @Override
    public X loadProxy() {
        var x = Proxy.newProxyInstance(PlConversationData.class.getClassLoader(), new Class[]{ clazz }, new ProxyingInvocationHandler(data));

        return (X) x;
    }
}
