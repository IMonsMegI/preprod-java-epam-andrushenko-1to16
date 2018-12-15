package com.epam.Andriushchenko.Task1.entities;

import java.util.Objects;

public class SmartTV extends Televisor {
    private boolean smartTV;
    private String operatingSystem;

    public SmartTV(boolean smartTV, String operatingSystem) {
        this.smartTV = smartTV;
        this.operatingSystem = operatingSystem;
    }

    public boolean isSmartTV() {
        return smartTV;
    }

    public void setSmartTV(boolean smartTV) {
        this.smartTV = smartTV;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    @Override
    public String toString() {
        return "SmartTV{" + "cost=" + super.getCost() + ", model='" + super.getModel() + ", power=" + super.getPower() +
                "diagonal=" + super.getDiagonal() + ", color=" + super.getCost() + ", height=" + super.getHeight() + ", width="
                + super.getWidth() + ", length=" + super.getLength() + "smartTV=" + smartTV + ", operatingSystem='" + operatingSystem + '}';
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

}
