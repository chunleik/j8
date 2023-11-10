package org.example.constructors;

public class PaymentService {
    private final String paymentMode;
    public PaymentService(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public PaymentService() {
        this.paymentMode = "Cash";
    }

    public String processPayment(){
        return this.paymentMode;
    }

    int t1() {
        System.out.println("fd");
        return 1;
    }
}
