package com.redspot;

public class Dog extends Animal {
    private String name;
    int runDistance = 500;

    public Dog(String name) {
        setName(name);
    }

    public Dog(String name, int runDistance) throws Exception {
        setName(name);
        setRunDistance(runDistance);
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRunDistance() {
        return runDistance;
    }

    public void setRunDistance(int runDistance) throws Exception {
        if (runDistance < 0) {
            throw new Exception("Некорректная дистанция бега");
        }
        this.runDistance = runDistance;
    }

    @Override
    protected boolean isRunDistanceValid(int distance) {
        return super.isRunDistanceValid(distance) && distance <= runDistance;
    }

    @Override
    protected boolean isJumpHeightValid(float height) {
        return super.isJumpHeightValid(height) && height <= 0.5;
    }

    @Override
    protected boolean isSwimDistanceValid(int distance) {
        return super.isSwimDistanceValid(distance) && distance <= 10;
    }
}
