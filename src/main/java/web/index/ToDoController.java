package web.index;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import web.dto.SaveRequestToDoDto;
import web.service.ToDoService;


@RequiredArgsConstructor
@RestController
public class ToDoController {


    private final ToDoService toDoService;


    @PostMapping("/todo/save")
    public Long saveToDo( @RequestBody SaveRequestToDoDto dto){



        return toDoService.saveToDo(dto);


    }


}
