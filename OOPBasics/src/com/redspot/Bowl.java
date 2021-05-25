package com.redspot;

public class Bowl {
    private int foodAmount;
    private int maxFoodAmount = 60;

    public Bowl() {
        refill();
    }

    public void refill() {
        foodAmount = maxFoodAmount;
        System.out.println("Миска наполнена!");
    }

    @Override
    public String toString() {
        return "Миска: \n" +
                "  Вместимость: " + maxFoodAmount + "\n" +
                "  Наполненность: " + foodAmount + '\n';
    }

    public boolean eatFrom(int eaten) {
        if (foodAmount - eaten < 0) {
            System.out.println("Не хватает еды в миске!");
            return false;
        }
        foodAmount -= eaten;
        System.out.println("Количество еды в миске уменьшилось на " + eaten);
        if (foodAmount == 0) {
            refill();
        }
        return true;
    }


}
