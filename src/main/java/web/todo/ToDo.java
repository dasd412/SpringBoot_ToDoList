package web.todo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity

public class ToDo {

    @Id
    @GeneratedValue
    private Long id;

    @Column(columnDefinition = "TEXT", length=100,nullable=false)
    private String content;


    @Column(nullable = false)
    private boolean star;

    @Builder
    public ToDo(String content, boolean star){
        this.content=content;
        this.star =star;
    }

    public void update(String content, boolean star){
        this.content=content;
        this.star=star;
    }



}
