package pgdp.stream;

public interface StreamOperation <T>{
    void start(StreamCharacteristics upstreamCharacteristics);
    void acceptElement(StreamElement<T> x);
    void finish();
    boolean needsMoreElements();


}
