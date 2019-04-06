package com.api.BankruptcyRiskAssessment.controller;

import com.api.BankruptcyRiskAssessment.BankruptcyRiskAssessmentApplication;
import com.api.BankruptcyRiskAssessment.entity.Role;
import com.api.BankruptcyRiskAssessment.entity.User;
import com.api.BankruptcyRiskAssessment.repository.RoleRepository;
import com.api.BankruptcyRiskAssessment.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.http.Cookie;
import java.io.IOException;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = BankruptcyRiskAssessmentApplication.class)
@WebAppConfiguration
@EnableWebMvc
public class AuthenticateControllerTest {

    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype());

    @Autowired
    private WebApplicationContext ctx;

    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    private MappingJackson2HttpMessageConverter converter;


    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
        converter = new MappingJackson2HttpMessageConverter();
    }


    @Test
    public void postRegistration() throws Exception {
        userRepository.deleteAll();

        mockMvc.perform(post("/api/registration")
                .contentType(contentType)
                .accept(contentType)
                .content(json(createUser())))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void postLogin() throws Exception {
        userRepository.deleteAll();

        Cookie[] cookies = mockMvc.perform(post("/api/registration")
                .contentType(contentType)
                .accept(contentType)
                .content(json(createUser())))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getCookies();


        mockMvc.perform(post("/api/logout")
                .cookie(cookies))
                .andDo(print())
                .andExpect(status().isOk());

        mockMvc.perform(post("/api/login")
                .contentType(contentType)
                .content(json(createUser())))
                .andDo(print())
                .andExpect(status().isOk());


    }

    @Test
    public void logout() throws Exception {
        userRepository.deleteAll();

        Cookie[] cookies = mockMvc.perform(post("/api/registration")
                .contentType(contentType)
                .accept(contentType)
                .content(json(createUser())))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getCookies();


        mockMvc.perform(post("/api/logout")
                .cookie(cookies))
                .andDo(print())
                .andExpect(status().isOk());
    }

    protected String json(Object o) throws IOException {
        MockHttpOutputMessage mockHttpOutputMessage = new MockHttpOutputMessage();
        converter.write(
                o, MediaType.APPLICATION_JSON, mockHttpOutputMessage);
        return mockHttpOutputMessage.getBodyAsString();
    }


    protected User createUser() {
        User user = new User();
        user.setFirstName("testFirstName111");
        user.setLastName("testLastName111");
        user.setPassword("testPass111");
        user.setLogin("testLogin");
        Role role = roleRepository.findByNameLike("Admin");
        user.setRole(role);
        return user;
    }

}
