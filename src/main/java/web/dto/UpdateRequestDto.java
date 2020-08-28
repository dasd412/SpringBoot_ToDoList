package web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Getter
@NoArgsConstructor
public class UpdateRequestDto {

    private  String content;
    private  boolean star;

    @Builder
    public UpdateRequestDto(String content,boolean star){
        this.content=content;
        this.star=star;
    }


}
