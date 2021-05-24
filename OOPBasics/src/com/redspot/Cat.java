package com.redspot;

public class Cat extends Animal {
    private String name;
    private float jumpHeight = 2;

    public Cat(String name) {
        setName(name);
    }

    public Cat(String name, float jumpHeight) throws Exception {
        setName(name);
        setJumpHeight(jumpHeight);
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getJumpHeight() {
        return jumpHeight;
    }

    public void setJumpHeight(float jumpHeight) throws Exception {
        if (jumpHeight < 0) {
            throw new Exception("Некорректная высота прыжка");
        }
        this.jumpHeight = jumpHeight;
    }

    @Override
    protected boolean isRunDistanceValid(int distance) {
        return super.isRunDistanceValid(distance) && distance <= 200;
    }

    @Override
    protected boolean isJumpHeightValid(float height) {
        return super.isJumpHeightValid(height) && height <= jumpHeight;
    }

    @Override
    protected boolean isSwimDistanceValid(int distance) {
        return super.isSwimDistanceValid(0);
    }
}
