package pgdp.stream;
@FunctionalInterface
public interface StreamOperable<T>{
    StreamOperation <T> getStreamOperation ();
}
