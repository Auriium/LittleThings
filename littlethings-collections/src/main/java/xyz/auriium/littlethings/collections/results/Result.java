package xyz.auriium.littlethings.collections.results;

public interface Result<T> {

    T getSuccess();
    Failure getFailure();

    boolean isSuccess();
    boolean isFailure();

    static <T> Result<T> success(T value) {
        return new SuccessfulResult<>(value);
    }

    static <T> Result<T> fail(Failure failure) {
        return new FailingResult<>(failure);
    }

}
