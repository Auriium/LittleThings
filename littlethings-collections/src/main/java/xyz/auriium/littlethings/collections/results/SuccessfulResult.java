package xyz.auriium.littlethings.collections.results;

public class SuccessfulResult<T> implements Result<T> {

    private final T completion;

    SuccessfulResult(T completion) {
        this.completion = completion;
    }

    @Override
    public T getSuccess() {
        return completion;
    }

    @Override
    public Failure getFailure() {
        throw new UnsupportedOperationException("Successful Result has no failure");
    }

    @Override
    public boolean isSuccess() {
        return true;
    }

    @Override
    public boolean isFailure() {
        return false;
    }

}
