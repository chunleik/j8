package org.example.constructors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PaymentProcessorTest {

    @Test
    void whenConstructorInvokedWithInitializer_ThenMockObjectShouldBeCreated(){
        try(MockedConstruction<PaymentService> mockPaymentService = Mockito.mockConstruction(PaymentService.class,(mock, context)-> {
            when(mock.processPayment()).thenReturn("Credit");
        })){
            PaymentProcessor paymentProcessor = new PaymentProcessor();
            Assertions.assertEquals(1,mockPaymentService.constructed().size());
            Assertions.assertEquals("Credit", paymentProcessor.processPayment());
        }
    }

    @Test
    void whenConstructorInvokedWithoutInitializer_ThenMockObjectShouldBeCreatedWithNullFields(){
        try(MockedConstruction<PaymentService> mockPaymentService = Mockito.mockConstruction(PaymentService.class)){
            PaymentProcessor paymentProcessor = new PaymentProcessor();
            Assertions.assertEquals(1,mockPaymentService.constructed().size());
            Assertions.assertNull(paymentProcessor.processPayment());
        }
    }

    @Test
    void whenConstructorInvokedWithParameters_ThenMockObjectShouldBeCreated(){
        try(MockedConstruction<PaymentService> mockPaymentService = Mockito.mockConstruction(PaymentService.class,(mock, context) -> {
            when(mock.processPayment()).thenReturn("Credit");
        })){
            PaymentProcessor paymentProcessor = new PaymentProcessor("Debit");
            Assertions.assertEquals(1,mockPaymentService.constructed().size());
            Assertions.assertEquals("Credit", paymentProcessor.processPayment());
        }
    }

    @Test
    void t1_test() {
        PaymentService mock = Mockito.mock(PaymentService.class);
        Mockito.when(mock.t1()).thenReturn(111);
        System.out.println(mock.t1());
    }

    @Mock
    private PaymentService paymentService;

    @InjectMocks
    private PaymentProcessor paymentProcessor;

    @Test
    void t2() {
        Mockito.when(paymentService.processPayment()).thenReturn("ffff");
        Assertions.assertEquals("ffff", paymentService.processPayment(), "1");
        Assertions.assertEquals("ffff", paymentProcessor.processPayment(), "2");
    }



}