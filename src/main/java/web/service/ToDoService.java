package web.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dto.ResponseToDoDto;
import web.dto.SaveRequestToDoDto;
import web.dto.UpdateRequestDto;
import web.todo.ToDo;
import web.todo.ToDoRepository;

@RequiredArgsConstructor
@Service
public class ToDoService {


   private final ToDoRepository toDoRepository;

    @Transactional
    public Long saveToDo(SaveRequestToDoDto dto){


        return toDoRepository.save(dto.toEntity()).getId();
    }


    @Transactional
    public Long updateToDo(Long id, UpdateRequestDto dto) {
        ToDo found=toDoRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("id not found : "+id));

        found.update(dto.getContent(),dto.isStar());



        return id;

    }

    public ResponseToDoDto findById(Long id) {
        ToDo found=toDoRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("not found id"+id));


        ResponseToDoDto dto=new ResponseToDoDto(found);

        return dto;

    }

    @Transactional
    public Long delete(Long id) {

         ToDo found=toDoRepository.findById(id)
                 .orElseThrow(()->new IllegalArgumentException("not found id "+id));

         toDoRepository.delete(found);


         return id;
    }
}
