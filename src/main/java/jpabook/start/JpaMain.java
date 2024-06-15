package jpabook.start;

import javax.persistence.*;
import java.util.List;

/**
 * @author holyeye
 */
public class JpaMain {

    public static void main(String[] args) {

        //엔티티 매니저 팩토리 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
        EntityManager em = emf.createEntityManager(); //엔티티 매니저 생성

        EntityTransaction tx = em.getTransaction(); //트랜잭션 기능 획득

        try {
            tx.begin(); //트랜잭션 시작
            teamMember(em);
            tx.commit();//트랜잭션 커밋

        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback(); //트랜잭션 롤백
        } finally {
            em.close(); //엔티티 매니저 종료
        }

        emf.close(); //엔티티 매니저 팩토리 종료
    }

    public static void teamMember(EntityManager em) {
        Team team = em.find(Team.class, 1L);
        System.out.println(team.getTname());

        //JPQL
        List<Member> members = em.createQuery("select M from Member M where M.teamId = :teamId", Member.class)
                .setParameter("teamId", 2L)
                .getResultList();

        for (int i = 0; i < members.size(); i++) {
            System.out.println(members.get(i).getUsername());
        }
    }


}