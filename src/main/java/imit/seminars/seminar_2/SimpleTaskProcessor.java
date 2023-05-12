package imit.seminars.seminar_2;

import java.util.Objects;

public class SimpleTaskProcessor implements ITaskProcessor  {
    private final SimpleBuffer<Integer> buff;

    public SimpleTaskProcessor() {
        this.buff = new SimpleBuffer<Integer>();
    }

    @Override
    public Integer process(final ITask task) {
        Objects.requireNonNull(task, "null passed as Task");
        Integer sum = 0;
        for (var data : task.getData()) {
            buff.add(data);
        }

        return 0;
    }

    public SimpleBuffer<Integer> getBuff() {
        return buff;
    }
}
