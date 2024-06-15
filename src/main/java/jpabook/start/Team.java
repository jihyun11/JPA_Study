package jpabook.start;

import javax.persistence.*;

@Entity
@Table(name = "JPA_TEAM")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TEAM_ID")
    private Long teamId;

    @Column(name = "TNAME")
    private String tname;

    public Long getTeamId() {
        return teamId;
    }


    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }
}
