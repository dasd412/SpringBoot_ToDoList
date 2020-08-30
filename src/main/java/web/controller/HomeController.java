package web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import web.dto.ListResponseDto;
import web.dto.TimeDto;
import web.service.ToDoService;

import java.util.List;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@Controller
public class HomeController {

    private final ToDoService toDoService;

    @GetMapping("/")
    public String index_Root(Model model){

        LocalDateTime dateTime=LocalDateTime.now();


        TimeDto timeDto=new TimeDto(dateTime);


        model.addAttribute("time",timeDto);

        List<ListResponseDto> listResponseDtos=toDoService.findAllToDo();

        model.addAttribute("todos",listResponseDtos);

        return "index";
    }

}
