package hello.core.member;

public class MemberApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member testMember = new Member(1L, "test member", Grade.BASIC);
        memberService.join(testMember);

        Member findMember = memberService.findMember(1L);
        System.out.println("new Member : " + testMember.hashCode());
        System.out.println("find Member : " + findMember.hashCode());

        System.out.println("new Member : " + testMember.getName());
        System.out.println("find Member : " + findMember.getName());
    }
}
