package com.designPattens.strategyPatten;

/**
 * @author LiuPeng
 * @description
 * @date 2018/11/26
 */
public class Test {

    public static void main(String[] args) {

        Price price = new Price(100);
        PriceUse priceUse = new PriceUse(new MemberStrategy());
        System.out.println(priceUse.opreationPrice(price));

        PriceUse priceUse2 = new PriceUse(new UnMemberStrategy());
        System.out.println(priceUse2.opreationPrice(price));

    }
}
