package com.caionastu.javaspringexamples.java.builderPattern.product;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.logging.log4j.util.Strings;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public class Product {
    private UUID id;
    private String name;
    private BigDecimal unitPrice;
    private BigDecimal unitsInStock;
    private BigDecimal unitsOnOrder;
    private boolean discontinued;
    private String shortDescription;
    private String longDescription;
    private LocalDateTime createdAt;

    public static ProductBuilder builder(String name, BigDecimal unitPrice, BigDecimal unitsInStock) {
        return new ProductBuilder(name, unitPrice, unitsInStock);
    }

    public static final class ProductBuilder {
        private final UUID id;
        private final String name;
        private final BigDecimal unitPrice;
        private final BigDecimal unitsInStock;
        private BigDecimal unitsOnOrder = BigDecimal.ZERO;
        private boolean discontinued = false;
        private String shortDescription;
        private String longDescription;

        private ProductBuilder(String name, BigDecimal unitPrice, BigDecimal unitsInStock) {
            if (Strings.isBlank(name)) {
                throw new IllegalArgumentException("Empty name.");
            }

            if (checkLessOrEqualThanZero(unitPrice)) {
                throw new IllegalArgumentException("Unit price is less or equal 0.");
            }

            if (checkLessOrEqualThanZero(unitsInStock)) {
                throw new IllegalArgumentException("Units in stock is less or equal 0.");
            }

            id = UUID.randomUUID();
            this.name = name;
            this.unitPrice = unitPrice;
            this.unitsInStock = unitsInStock;
        }

        public ProductBuilder unitsOnOrder(BigDecimal unitsOnOrder) {
            if (checkLessThanZero(unitsOnOrder)) {
                throw new IllegalArgumentException("Units on order is less than zero 0.");
            }

            this.unitsOnOrder = unitsOnOrder;
            return this;
        }

        public ProductBuilder discontinued(boolean discontinued) {
            this.discontinued = discontinued;
            return this;
        }

        public ProductBuilder shortDescription(String shortDescription) {
            if (Strings.isBlank(shortDescription)) {
                throw new IllegalArgumentException("Short Description is empty.");
            }

            this.shortDescription = shortDescription;
            return this;
        }

        public ProductBuilder longDescription(String longDescription) {
            if (Strings.isBlank(longDescription)) {
                throw new IllegalArgumentException("Long Description is empty.");
            }

            this.longDescription = longDescription;
            return this;
        }

        public Product build() {
            Product product = new Product();
            product.longDescription = this.longDescription;
            product.shortDescription = this.shortDescription;
            product.id = this.id;
            product.unitsInStock = this.unitsInStock;
            product.createdAt = LocalDateTime.now();
            product.discontinued = this.discontinued;
            product.name = this.name;
            product.unitPrice = this.unitPrice;
            product.unitsOnOrder = this.unitsOnOrder;
            return product;
        }

        private boolean checkLessThanZero(BigDecimal value) {
            int result = value.compareTo(BigDecimal.ZERO);
            return result < 0;
        }

        private boolean checkLessOrEqualThanZero(BigDecimal value) {
            int result = value.compareTo(BigDecimal.ZERO);
            return result < 0 || result == 0;
        }
    }
}
