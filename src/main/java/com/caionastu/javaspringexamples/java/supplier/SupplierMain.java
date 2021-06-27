package com.caionastu.javaspringexamples.java.supplier;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Supplier;

@Slf4j
class SupplierMain {
    public static void main(String[] args) {
        Supplier<BlueTile> blueTileSupplier = BlueTile::new;
        Supplier<BlackTile> blackTileSupplier = BlackTile::new;
        Supplier<RedTile> redTileSupplier = RedTile::new;

        Mosaic blueMosaic = Mosaic.create(blueTileSupplier);
        log.info("Mosaic of tile color: {}.", blueMosaic.getColor());
        Mosaic blackMosaic = Mosaic.create(blackTileSupplier);
        log.info("Mosaic of tile color: {}.", blackMosaic.getColor());
        Mosaic redMosaic = Mosaic.create(redTileSupplier);
        log.info("Mosaic of tile color: {}.", redMosaic.getColor());
    }
}
