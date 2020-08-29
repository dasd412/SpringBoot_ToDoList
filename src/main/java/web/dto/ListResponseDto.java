package web.dto;

import lombok.Getter;
import web.todo.ToDo;

@Getter
public class ListResponseDto {

    private Long id;
    private String content;
    private boolean star;

    public ListResponseDto(ToDo entity){
        this.id=entity.getId();
        this.content=entity.getContent();
        this.star=entity.isStar();
    }

}
