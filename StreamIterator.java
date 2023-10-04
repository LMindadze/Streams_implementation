package pgdp.stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.OptionalLong;

public interface StreamIterator <T>{
    boolean hasNext();
    StreamElement<T> next();
    OptionalLong getSize ();

    private static <T> StreamIterator <T> of(Collection<T> collection){
        return new StreamIterator<T>() {
            @Override
            public boolean hasNext() {
                return collection.stream().iterator().hasNext();
            }

            @Override
            public StreamElement<T> next() {
                return (StreamElement<T>) collection.stream().iterator().next();
            }

            @Override
            public OptionalLong getSize() {
                return OptionalLong.of(collection.size());
            }
        };
    }
    private static <T> StreamIterator <T> of(Iterable<T> iterable){
        return new StreamIterator<T>() {
            @Override
            public boolean hasNext() {
                return iterable.iterator().hasNext();
            }

            @Override
            public StreamElement<T> next() {
                return (StreamElement<T>) iterable.iterator().next();
            }

            @Override
            public OptionalLong getSize() {
                return OptionalLong.of(iterable.spliterator().getExactSizeIfKnown());
            }
        };
    }
    private static <T> StreamIterator <T> of(T[] gen){
        return new StreamIterator<T>() {
            @Override
            public boolean hasNext() {
                return Arrays.stream(gen).iterator().hasNext();
            }

            @Override
            public StreamElement<T> next() {
                return (StreamElement<T>) Arrays.stream(gen).iterator().next();
            }

            @Override
            public OptionalLong getSize() {
                return OptionalLong.of(gen.length);
            }
        };
    }
    private static <T> StreamIterator <T> of(java.util.stream.Stream<T> stream){
        return new StreamIterator<T>() {
            @Override
            public boolean hasNext() {
                return stream.iterator().hasNext();
            }

            @Override
            public StreamElement<T> next() {
                return (StreamElement<T>) stream.iterator().next();
            }

            @Override
            public OptionalLong getSize() {
                return OptionalLong.of(stream.count());
            }
        };
    }
}
