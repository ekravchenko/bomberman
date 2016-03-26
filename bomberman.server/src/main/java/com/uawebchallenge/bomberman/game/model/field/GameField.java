package com.uawebchallenge.bomberman.game.model.field;

import java.util.Optional;

public class GameField {

    private final GameFieldItem[][] fieldItems;

    public GameField(int width, int height) {
        this.fieldItems = GameFieldGenerator.generateGameField(width, height);
    }

    public GameFieldItem[][] getFieldItems() {
        return fieldItems;
    }

    public Optional<GameFieldItem> getFieldItem(int x, int y) {
        if (y < 0 || y >= fieldItems.length || x < 0 || x >= fieldItems[y].length) {
            return Optional.empty();
        }
        return Optional.of(fieldItems[y][x]);
    }
}