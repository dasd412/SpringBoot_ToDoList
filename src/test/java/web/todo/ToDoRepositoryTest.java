package web.todo;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ToDoRepositoryTest {

    @Autowired
    ToDoRepository toDoRepository;

    @Test
    public void saveToDo(){
        //given
        String content="make todo list";
        boolean isSignificant=true;

        toDoRepository.save(ToDo.builder().content(content).star(isSignificant).build());

        //when
        List<ToDo>list=toDoRepository.findAll();

        //then



        assertThat(list.get(0).getContent()).isEqualTo(content);

        assertThat(list.get(0).isStar()).isEqualTo(isSignificant);

    }

    @After
    public void reInit(){
        toDoRepository.deleteAll();
    }

}