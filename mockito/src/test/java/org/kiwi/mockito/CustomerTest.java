package org.kiwi.mockito;

import org.junit.Before;
import org.junit.Test;
import org.kiwi.domain.Customer;
import org.kiwi.domain.Payment;
import org.kiwi.domain.Product;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CustomerTest {
    private Customer customer;
    private Payment mockPayment;

    @Before
    public void setUp() throws Exception {
        mockPayment = mock(Payment.class);
        customer = new Customer(mockPayment);
    }

    @Test
    public void should_pay_after_buy_product() {
        when(mockPayment.getBalance()).thenReturn(50);

        customer.buyProduct(new Product(50));
        assertThat(mockPayment.getBalance(), is(equalTo(50)));

        verify(mockPayment).withdraw(50);
    }
}
