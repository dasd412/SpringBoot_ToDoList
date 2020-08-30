package web.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dto.ListResponseDto;
import web.dto.ResponseToDoDto;
import web.dto.SaveRequestToDoDto;
import web.dto.UpdateRequestDto;
import web.todo.ToDo;
import web.todo.ToDoRepository;

import java.util.List;
import java.util.stream.Collectors;

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
    public void delete(Long id) {

         ToDo found=toDoRepository.findById(id)
                 .orElseThrow(()->new IllegalArgumentException("not found id "+id));

         toDoRepository.delete(found);


    }

    @Transactional(readOnly = true)
    public List<ListResponseDto> findAllToDo() {

        return toDoRepository.findAll().stream().
                map(ListResponseDto::new).
                collect(Collectors.toList());

    }

    @Transactional
    public Long updateStar(Long id) {
        ToDo target=toDoRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("not found id "+id));

        boolean star;

        if(target.isStar()){
            star=false;
        }
        else{
            star=true;
        }

        target.update_star(star);

        return id;


    }
}
