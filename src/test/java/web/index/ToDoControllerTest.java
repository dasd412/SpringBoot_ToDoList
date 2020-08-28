package web.index;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import web.dto.SaveRequestToDoDto;
import web.dto.UpdateRequestDto;
import web.todo.ToDo;
import web.todo.ToDoRepository;

import javax.persistence.EntityManager;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ToDoControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    TestRestTemplate testRestTemplate;

    @Autowired
    ToDoRepository toDoRepository;


    @Test
    public void test_saveToDo()throws Exception{



        //given
        String content="make a todoList";
        boolean isSignificant=true;

        SaveRequestToDoDto dto=SaveRequestToDoDto.builder()
                .content(content)
                .star(isSignificant)
                .build();



        String url="http://localhost:"+port+"/todo/save";



        //when
        ResponseEntity<Long>responseEntity=testRestTemplate.postForEntity(
                url,dto,Long.class
        );


//        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<ToDo> found=toDoRepository.findAll();

        assertThat(found.get(0).getContent()).isEqualTo(content);
      assertThat(found.get(0).isStar()).isEqualTo(isSignificant);



    }

    @After
    public void reInit()throws  Exception{
        toDoRepository.deleteAll();
    }


    @Test
    public void test_updateToDo()throws Exception{

        //given
        ToDo original= ToDo.builder().content("original content").star(false).build();
        toDoRepository.save(original);

        String content="updated content";
        boolean star=true;

        UpdateRequestDto dto= UpdateRequestDto.builder().content(content).star(star).build();

        String url="http://localhost:"+port+"/todo/update/"+original.getId();

        HttpEntity<UpdateRequestDto>httpEntity=new HttpEntity<>(dto);

        //when

        ResponseEntity<Long>responseEntity=testRestTemplate.exchange(url, HttpMethod.PUT, httpEntity,Long.class);

        //then

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);


        List<ToDo>toDos=toDoRepository.findAll();

        assertThat(toDos.get(0).getContent()).isEqualTo(content);
        assertThat(toDos.get(0).isStar()).isEqualTo(star);




    }


}