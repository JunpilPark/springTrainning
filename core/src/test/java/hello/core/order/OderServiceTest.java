package hello.core.order;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OderServiceTest {

    private AppConfig appConfig = new AppConfig();
    private MemberService memberService;
    private OrderService orderService;

    @BeforeEach
    public void setUp() {

        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "Test", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "Product1", 9000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(900);
    }
}
