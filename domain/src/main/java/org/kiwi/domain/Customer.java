package org.kiwi.domain;

public class Customer {
    private Payment payment;

    public Customer(Payment payment) {
        this.payment = payment;
    }

    public void buyProduct(Product product) {
        payment.withdraw(product.getPrice());
    }
}
