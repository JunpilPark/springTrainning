package hello.core.order;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OderServiceTest {

    private MemberService memberService = new MemberServiceImpl();
    private OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "Test", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "Product1", 9000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
