package com.redspot;

public class Cat extends Animal {
    private String name;
    private float jumpHeight = 2;
    private boolean satiety = false;
    private int appetite = 15;

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

    public void eat(Bowl bowl) {
        if(!satiety) {
            if (bowl.eatFrom(appetite)) {
                satiety = true;
                System.out.println("Котик покушал!");
            } else {
                System.out.println("Котику мало еды!");
            }
        } else
            System.out.println("Котик сыт!");
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

    @Override
    public String toString() {
        return "Имя котика: " + name + "\n" +
                "  Cыт? " + satiety + "\n" +
                "  Аппетит: " + appetite + "\n" +
                "  Высота прыжка: " + jumpHeight + "\n";
    }
}
