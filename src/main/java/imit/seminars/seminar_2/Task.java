package imit.seminars.seminar_2;

import java.util.Arrays;
import java.util.Objects;

public class Task implements ITask {
    private final int[] data;

    public Task(final int... data) {
        Objects.requireNonNull(data, "Error: data is null");
        this.data = data;
    }

    @Override
    public int[] getData() {
        return data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task task)) return false;
        return Arrays.equals(getData(), task.getData());
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(getData());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Task{");
        sb.append("data=");
        sb.append('[');
        for (int i = 0; i < data.length; ++i) {
            sb.append(i == 0 ? "" : ", ")
                .append(data[ i ]);
        }
        sb.append(']');
        sb.append('}');

        return sb.toString();
    }
}
