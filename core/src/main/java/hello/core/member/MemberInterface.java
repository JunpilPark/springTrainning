package hello.core.member;

public interface MemberInterface {
    void  save(Member member);
    Member findById(Long memberId);
}
