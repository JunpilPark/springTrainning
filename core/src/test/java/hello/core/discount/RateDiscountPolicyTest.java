package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 상품 가격의 10% 할인이 적용되어야 한다.")
    void vip_o() {
        //given
        Member member = new Member(1L, "TEST", Grade.VIP);

        //when
        int discount = discountPolicy.discount(member, 10000);

        //then
        assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("일반회원은 할인 정책이 적용되지 않는다.")
    void vip_x() {
        //given
        Member member = new Member(1L, "TEST", Grade.BASIC);

        //when
        int discount = discountPolicy.discount(member, 10000);

        //Then
        assertThat(discount).isEqualTo(0);
    }

}