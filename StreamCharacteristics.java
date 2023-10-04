package pgdp.stream;

import java.util.OptionalLong;

public final class StreamCharacteristics {

    private OptionalLong getStreamSize() {
        return OptionalLong.empty();
    }

    private boolean isDistinct() {
        return false;
    }

    boolean isCheck() {
        return false;
    }

    private static StreamCharacteristics regular() {
        return null ;
    }

    private StreamCharacteristics withStreamSize(long size) {
        return null ;
    }

    private StreamCharacteristics withDistinct(boolean distinct) {
        return null ;
    }

    private StreamCharacteristics withChecked(boolean checked) {
        return null ;
    }
}