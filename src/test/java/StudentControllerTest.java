import com.jojo.controller.StudentController;
import com.jojo.entity.Student;
import com.jojo.service.StudentService;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@WebMvcTest(StudentController.class)
@ContextConfiguration(classes={StudentController.class})
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentService studentService;

    @Test
    public void testToGetAllStudents() throws Exception {
        Student jay = new Student(1, "Jay", "CIS");
        Student jojo = new Student(2, "Jojo", "CIS");
        Student dodo = new Student(3, "Dodo", "Fiance");
        List<Student> allStudents = Arrays.asList(jay, jojo, dodo);

        Mockito.when(studentService.getAllStudents()).thenReturn(allStudents);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/students").accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        System.out.println("=================================");
        System.out.println(result.getResponse().getContentAsString());


    }
}
