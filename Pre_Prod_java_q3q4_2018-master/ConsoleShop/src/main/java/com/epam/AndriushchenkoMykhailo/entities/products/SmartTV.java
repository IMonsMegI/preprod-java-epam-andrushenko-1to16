package com.epam.AndriushchenkoMykhailo.entities.products;

import java.math.BigDecimal;
import java.util.Objects;

public class SmartTV extends TV {
    private boolean smartTV;
    private String operatingSystem;

    public SmartTV() {
    }

    public SmartTV(int id, BigDecimal cost, String model, int power, double diagonal, boolean color, double height, double width, double length, boolean smartTV, String operatingSystem) {
        super(id, cost, model, power, diagonal, color, height, width, length);
        this.smartTV = smartTV;
        this.operatingSystem = operatingSystem;
    }

    @Override
    public String toString() {
        return "SmartTV {" + "id=" + super.getId() + ", cost=" + super.getCost() + ", model=" + super.getModel() + ", power=" + super.getPower() +
                ", diagonal=" + super.getDiagonal() + ", color=" + super.getCost() + ", height=" + super.getHeight() + ", width="
                + super.getWidth() + ", length=" + super.getLength() + ", smartTV=" + smartTV + ", operatingSystem=" + operatingSystem + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SmartTV smartTV1 = (SmartTV) o;
        return smartTV == smartTV1.smartTV && Objects.equals(operatingSystem, smartTV1.operatingSystem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), smartTV, operatingSystem);
    }

    public void setSmartTV(boolean smartTV) {
        this.smartTV = smartTV;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public boolean isSmartTV() {
        return smartTV;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }
}
