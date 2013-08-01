package org.kiwi.domain;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class CustomerTest {

    private Payment payment;
    private Customer customer;

    @Before
    public void setUp() throws Exception {
        payment = new Payment(100);
        customer = new Customer(payment);
    }

    @Test
    public void should_pay_after_buy_product() {
        customer.buyProduct(new Product(50));
        assertThat(payment.getBalance(), is(equalTo(50)));
    }
}