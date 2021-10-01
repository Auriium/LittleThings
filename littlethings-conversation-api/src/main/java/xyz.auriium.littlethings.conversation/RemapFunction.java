package xyz.auriium.littlethings.conversation;

import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public interface RemapFunction extends BiFunction<String, Object, Object> {

    String identifier();

}
