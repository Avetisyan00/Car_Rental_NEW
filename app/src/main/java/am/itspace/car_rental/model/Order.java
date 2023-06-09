package am.itspace.car_rental.model;

import java.time.LocalDate;

public class Order {
    private int id;
    private LocalDate orderStart;
    private LocalDate orderEnd;
    private User driver;
    private User dealer;
    private User client;
    private Car car;
    private double amount;
}