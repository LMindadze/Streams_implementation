package pgdp.stream;

public class SourcePart<T> extends AbstractStreamPart <T,T>{
    StreamIterator <T> iterator;
    StreamCharacteristics characteristics;

    public SourcePart(StreamIterator<T> iterator, StreamCharacteristics characteristics) {
        this.iterator = iterator;
        this.characteristics = characteristics;
    }



    @Override
    SourcePart<?> GetSource() {
        return null;
    }
    StreamOperation getStreamOperation (){
        return null;
    }

    void processStream(){

    }


}
