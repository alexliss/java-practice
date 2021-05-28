package com.redspot;

public class GamePlayer {
    private final char playerSign;
    private final boolean isRealPlayer;

    public GamePlayer(char playerSign, boolean isRealPlayer) {
        this.playerSign = playerSign;
        this.isRealPlayer = isRealPlayer;
    }

    public boolean isRealPlayer() {
        return isRealPlayer;
    }

    public char getPlayerSign() {
        return playerSign;
    }
}
