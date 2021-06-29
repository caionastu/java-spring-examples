package com.caionastu.javaspringexamples.java.supplier;

import lombok.AllArgsConstructor;

import java.awt.*;
import java.util.function.Supplier;

@AllArgsConstructor
class Mosaic {

    private final Tile tile;

    public Color getColor() {
        return tile.getColor();
    }

    public static Mosaic create(Supplier<? extends Tile> tileFactory) {
        Tile tile = tileFactory.get();
        return new Mosaic(tile);
    }
}
