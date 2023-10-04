package pgdp.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class  StreamElement <T> {
    private final T element;
    private final List<Exception> exceptions;

    private StreamElement(T element) { //regular
        this.element = element;
        this.exceptions = new ArrayList<>();
    }

    private StreamElement(List<Exception> exceptions) { //faulty
        this.element = null;
        this.exceptions = exceptions;
    }

    private T  getElement() {
        return element;
    }

    private List<Exception> getExceptions() {
        return exceptions;
    }

    private boolean hasExceptions (){
        return !(exceptions.size() == 0);
    }

    <R> StreamElement<R> withExceptionAdded (Exception ex){
        List<Exception> exlist = new ArrayList<>(exceptions);
        exlist.add(ex);
        return new StreamElement<R>(exceptions);
    }

    <R> StreamElement <R> tryAdapt (){
        if (exceptions == null) {
            throw new UnsupportedOperationException();
        }
        else {
            return new StreamElement<>(exceptions);
        }

    }

    <T> StreamElement <T> of (T t){
        return new StreamElement<T>(t);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StreamElement<?> that = (StreamElement<?>) o;
        return Objects.equals(element, that.element) && Objects.equals(exceptions, that.exceptions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(element, exceptions);
    }

    @Override
    public String toString() {
        return "StreamElement{" +
                "element=" + element +
                ", exceptions=" + exceptions +
                '}';
    }
}
