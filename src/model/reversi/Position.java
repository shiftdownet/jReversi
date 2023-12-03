
package model.reversi;

import java.util.Objects;

public class Position {
    private final Integer y;
    private final Integer x;

    public Position(final Integer y, final Integer x) {
        this.y = y;
        this.x = x;
    }

    public Integer y() {
        return this.y;
    }

    public Integer x() {
        return this.x;
    }

    public Position add(final Position pos) {
        return new Position(this.y() + pos.y(), this.x() + pos.x());
    }

    public Position sub(final Position pos) {
        return new Position(this.y() - pos.y(), this.x() - pos.x());
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj instanceof Position) {
            Position key = (Position) obj;
            return this.x() == key.x() && this.y() == key.y();
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.x(), this.y());
    }
}