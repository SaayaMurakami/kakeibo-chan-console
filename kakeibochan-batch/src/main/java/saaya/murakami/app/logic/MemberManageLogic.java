package saaya.murakami.app.logic;

import javax.annotation.Resource;

import saaya.murakami.dbflute.exbhv.MemberBhv;
import saaya.murakami.dbflute.exbhv.StatementBhv;
import saaya.murakami.dbflute.exentity.Member;

public class MemberManageLogic {

    @Resource
    private MemberBhv memberBhv;
    @Resource
    private StatementBhv statementBhv;

    public void insertMember() {
        Member member = new Member();
        member.setMailAddress("aaaa");

        //....

        memberBhv.insert(member);
    }
}
