package web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import web.dto.ResponseToDoDto;
import web.dto.SaveRequestToDoDto;
import web.dto.UpdateRequestDto;
import web.service.ToDoService;


@RequiredArgsConstructor
@RestController
public class ToDoController {


    private final ToDoService toDoService;


    @PostMapping("/todo")
    public Long saveToDo( @RequestBody SaveRequestToDoDto dto){



        return toDoService.saveToDo(dto);


    }

    @PutMapping("/todo/{id}")
    public Long updateToDo(@PathVariable Long id, @RequestBody UpdateRequestDto dto){

      return  toDoService.updateToDo(id,dto);

    }

    @PutMapping("/todo/star/{id}")
    public Long updateStar(@PathVariable Long id){

        return toDoService.updateStar(id);
    }

    @GetMapping("/todo/{id}")
    public ResponseToDoDto findToDo(@PathVariable Long id){



        return toDoService.findById(id);
    }

    @DeleteMapping("/todo/{id}")
    public Long deleteToDo(@PathVariable Long id){
         toDoService.delete(id);
         return id;
    }


}
