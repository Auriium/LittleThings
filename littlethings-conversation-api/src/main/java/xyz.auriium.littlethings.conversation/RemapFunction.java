package xyz.auriium.littlethings.conversation;

import java.util.function.BiFunction;

public interface RemapFunction extends BiFunction<String, Object, Object> {

    String identifier();

}
