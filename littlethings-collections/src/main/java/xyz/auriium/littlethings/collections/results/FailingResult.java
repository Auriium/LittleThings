package xyz.auriium.littlethings.collections.results;

public class FailingResult<T> implements Result<T> {

    private final Failure failure;

    FailingResult(Failure failure) {
        this.failure = failure;
    }

    @Override
    public T getSuccess() {
        throw new UnsupportedOperationException("Failing result does not return success!");
    }

    @Override
    public Failure getFailure() {
        return failure;
    }

    @Override
    public boolean isSuccess() {
        return false;
    }

    @Override
    public boolean isFailure() {
        return true;
    }
}
