package web.dto;

import lombok.Getter;
import web.todo.ToDo;

@Getter
public class ResponseToDoDto {

    private Long id;
    private String content;
    private boolean star;

    public ResponseToDoDto(ToDo entity){
        this.id=entity.getId();
        this.content=entity.getContent();
        this.star=entity.isStar();
    }
}
