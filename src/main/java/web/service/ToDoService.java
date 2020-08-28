package web.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dto.SaveRequestToDoDto;
import web.todo.ToDoRepository;

@RequiredArgsConstructor
@Service
public class ToDoService {


   private final ToDoRepository toDoRepository;

    @Transactional
    public Long saveToDo(SaveRequestToDoDto dto){


        return toDoRepository.save(dto.toEntity()).getId();
    }



}
