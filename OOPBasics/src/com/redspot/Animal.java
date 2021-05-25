package com.redspot;

public abstract class Animal {

    public void run(int distance) {
        boolean isValid = isRunDistanceValid(distance);
        System.out.println("run(" + distance + "): " + isValid);
    }

    public void jump(float height) {
        boolean isValid = isJumpHeightValid(height);
        System.out.println("jump(" + height + "): " + isValid);
    }

    public void swim(int distance) {
        boolean isValid = isSwimDistanceValid(distance);
        System.out.println("swim(" + distance + "): " + isValid);

    }

    protected boolean isRunDistanceValid(int distance) {
        return distance > 0;
    }

    protected boolean isJumpHeightValid(float height) {
        return height > 0;
    }

    protected boolean isSwimDistanceValid(int distance) {
        return distance > 0;
    }

    public abstract String getName();
}
