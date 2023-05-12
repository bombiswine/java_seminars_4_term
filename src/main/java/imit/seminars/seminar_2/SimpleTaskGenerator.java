package imit.seminars.seminar_2;

import java.util.Objects;

public class SimpleTaskGenerator implements ITaskGenerator {
    private SimpleBuffer<Integer> buff;
    private int startValue;
    private int amount;

    public SimpleTaskGenerator() {
        this.startValue = 0;
        this.amount = 0;
        this.buff = new SimpleBuffer<>();
    }

    public SimpleTaskGenerator(
        final int startValue,
        final int amount
    ) {
        this.startValue = startValue;
        this.amount = amount;
        this.buff = new SimpleBuffer<>();
    }

    @Override
    public void generate() {
        for (int i = getStartValue(); i < getStartValue() + getAmount(); i++) {
            buff.add(i);
        }
    }

    public SimpleBuffer<Integer> getBuff() {
        return buff;
    }

    public int getStartValue() {
        return startValue;
    }

    public int getAmount() {
        return amount;
    }

    public SimpleTaskGenerator withStartValue(final int startValue) {
        this.startValue = startValue;
        return this;
    }

    public SimpleTaskGenerator withAmount(final int amount) {
        this.amount = amount;
        return this;
    }
}
