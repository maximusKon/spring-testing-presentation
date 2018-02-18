package ru.maximov.springtestingpresentation.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.val;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import ru.maximov.springtestingpresentation.configproperties.SchoolClubPropertiesConfig;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(RockBandController.class)
public class RockBandControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RockBandService rockBandService;

    @Test
    public void getById_Success_VerifyJson() throws Exception {

        when(rockBandService.getById(1)).thenReturn(new RockBand(1, "Король и Шут"));

        mockMvc.perform(get("/rock_band/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.name", is("Король и Шут")));

    }

    @Test
    public void getById_NoSuchObject_VerifyError() throws Exception {

        when(rockBandService.getById(123)).thenThrow(new NoSuchObjectException("Нет группой с таким id"));

        mockMvc.perform(get("/rock_band/123"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Нет группой с таким id"));

    }

    @Test
    public void post_addRockBand_VerifyResult() throws Exception {
        val rockBand = new RockBand(2, "КняZZ");
        val jsonString = (new ObjectMapper()).writeValueAsString(rockBand);

        mockMvc.perform(
                post("/rock_band/add").content(jsonString).contentType(MediaType.APPLICATION_JSON_UTF8)
        ).andExpect(status().isOk());

        verify(rockBandService).add(rockBand);
    }
}