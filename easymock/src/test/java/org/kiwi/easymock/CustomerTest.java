package org.kiwi.easymock;

import org.easymock.IAnswer;
import org.junit.Before;
import org.junit.Test;
import org.kiwi.domain.Customer;
import org.kiwi.domain.Payment;
import org.kiwi.domain.Product;

import static org.easymock.EasyMock.*;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class CustomerTest {
    private Payment mockPayment;
    private Customer customer;


    @Before
    public void setUp() throws Exception {
        mockPayment = createMock(Payment.class);
        customer = new Customer(mockPayment);
    }

    @Test
    public void should_pay_after_buy_product() {
        //record expect behavior
        mockPayment.withdraw(eq(50));

        //make the mock methods works
        replay(mockPayment);

        //when
        customer.buyProduct(new Product(50));

        //verify the mock objects of the expected behavior
        verify(mockPayment);
    }


    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_after_buy_expensive_product() {
        mockPayment.withdraw(anyInt());
        expectLastCall().andStubThrow(new IllegalArgumentException("Money is not enough"));

        replay(mockPayment);

        customer.buyProduct(new Product(50));
    }

    @Test
    public void should_get_balance_100_with_ansReturn() {
        expect(mockPayment.getBalance()).andStubReturn(100);

        replay(mockPayment);

        assertThat(mockPayment.getBalance(), is(equalTo(100)));

        verify(mockPayment);
    }

    @Test
    public void should_get_balance_100_with_andAnswer() {
        expect(mockPayment.getBalance()).andStubAnswer(new IAnswer<Integer>() {
            @Override
            public Integer answer() throws Throwable {
                return 100;
            }
        });

        replay(mockPayment);

        assertThat(mockPayment.getBalance(), is(equalTo(100)));

        verify(mockPayment);
    }
}
