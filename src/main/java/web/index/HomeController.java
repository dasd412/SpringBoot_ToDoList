package web.index;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import web.dto.TimeDto;

import java.time.LocalDateTime;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index_Root(Model model){

        LocalDateTime dateTime=LocalDateTime.now();


        TimeDto timeDto=new TimeDto(dateTime);


        model.addAttribute("time",timeDto);

        return "index";
    }

}
