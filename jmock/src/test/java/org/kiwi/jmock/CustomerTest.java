package org.kiwi.jmock;

import org.jmock.Mockery;
import org.junit.Test;
import org.kiwi.domain.Payment;

public class CustomerTest {
    Mockery mockery = new Mockery();

    @Test(expected = IllegalArgumentException.class)
    public void should_pay_after_buy_product() {
        //jmock cannot easily mock class, but interface
        mockery.mock(Payment.class);
    }
}
