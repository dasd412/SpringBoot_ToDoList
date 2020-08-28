package web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import web.todo.ToDo;

@Getter
@NoArgsConstructor
public class SaveRequestToDoDto {

    private  String content;

    private  boolean star;

    @Builder
    public SaveRequestToDoDto(String content, boolean star){
        this.content=content;
        this.star=star;

    }

    public ToDo toEntity(){

        return ToDo.builder().content(content).star(star).build();
    }

}
