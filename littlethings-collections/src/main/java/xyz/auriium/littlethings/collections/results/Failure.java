package xyz.auriium.littlethings.collections.results;

public interface Failure {

    <T> T param(String key, Class<T> clazz);

}
