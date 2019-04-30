import podgotovkades.rest.controller.Controller;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {ControllerTest.class})
public class ControllerTest {
    private MockMvc mockMvc;
    @InjectMocks
    private Controller controller;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(controller)
                .build();
    }

    @Test
    public void test() {
        Assert.assertEquals(true, true);
    }

    @Test
    public void controllerHelloTest() throws Exception {
mockMvc.perform(get("/hello")).andExpect(status().isOk());
        Assert.assertEquals(true, true);
    }
}


