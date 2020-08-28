package web.index;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import web.dto.SaveRequestToDoDto;
import web.dto.UpdateRequestDto;
import web.service.ToDoService;


@RequiredArgsConstructor
@RestController
public class ToDoController {


    private final ToDoService toDoService;


    @PostMapping("/todo/save")
    public Long saveToDo( @RequestBody SaveRequestToDoDto dto){



        return toDoService.saveToDo(dto);


    }

    @PutMapping("/todo/update/{id}")
    public Long updateToDo(@PathVariable Long id, @RequestBody UpdateRequestDto dto){

      return  toDoService.updateToDo(id,dto);

    }


}
