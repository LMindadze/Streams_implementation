package pgdp.stream;

public abstract class AbstractStreamPart <IN, OUT>{

    Stream <OUT> outStream;
    StreamOperable <IN> inStreamOperable;
    StreamOperable <OUT> next;

    StreamOperation <IN> getStreamOperation (){
        return inStreamOperable.getStreamOperation();
    }

    void setNext (StreamOperable <OUT> next) throws Exception{
        if(this.next == next)
            throw new IllegalStateException();
        else
            this.next = next;
    }

    abstract SourcePart <?> GetSource ();
}
