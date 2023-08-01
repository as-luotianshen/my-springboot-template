package net.rakan.god.myspringboottemplate;

import java.math.BigDecimal;

public class Ex {
    public static void main(String[] args) {
        BigDecimal b1 = new BigDecimal(1);
        BigDecimal b2 = new BigDecimal(1.0);
        int scale = b2.scale();
        int scale1 = b1.scale();

        System.out.println(scale1);
        System.out.println(scale);

        System.out.println(b1.equals(b2));
    }
}
