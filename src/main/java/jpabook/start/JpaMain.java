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
            depositLogic(em);
            tx.commit();//트랜잭션 커밋

        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback(); //트랜잭션 롤백
        } finally {
            em.close(); //엔티티 매니저 종료
        }

        emf.close(); //엔티티 매니저 팩토리 종료
    }

    public static void depositLogic(EntityManager em) {
        //0001 추가
        Deposit deposit = new Deposit();
        deposit.setAmount(10000);
        deposit.setUsername("테스트");

        // 0002 추가
        Deposit deposit2 = new Deposit();
        deposit2.setAmount(15000);
        deposit2.setUsername("테스트2");

        // 0003 추가
        Deposit deposit3 = new Deposit();
        deposit3.setAmount(3000);
        deposit3.setUsername("테스트3");

        //등록
        em.persist(deposit);
        em.persist(deposit2);
        em.persist(deposit3);

        //삭제
        em.remove(deposit);
        em.remove(deposit2);
        em.remove(deposit3);
    }
}