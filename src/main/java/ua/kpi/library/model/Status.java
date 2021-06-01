package ua.kpi.library.model;

import lombok.ToString;

@ToString
public enum Status {
    PENDING("Pending"),
    CONFIRMED("Confirmed"),
    SHIPPED("Shipped"),
    DELIVERED("Delivered"),
    CANCELLED("Cancelled");

    private final String title;

    Status(String title) {
        this.title = title;
    }
}
