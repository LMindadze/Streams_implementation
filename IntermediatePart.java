package pgdp.stream;

public abstract class IntermediatePart <IN, OUT> extends AbstractStreamPart<IN, OUT>{
    AbstractStreamPart <?, IN> abstractStreamPart;
    StreamOperable <OUT> next;

    private IntermediatePart(AbstractStreamPart<?, IN> abstractStreamPart) {
        this.abstractStreamPart = abstractStreamPart;
    }

    @Override
    void setNext(StreamOperable<OUT> next) throws Exception {
        super.setNext(next);
    }

    @Override
    SourcePart<?> GetSource() {
        return null;
    }
}
