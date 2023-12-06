package com.example.diningreview.controller;

import com.example.diningreview.enums.CuisineType;
import com.example.diningreview.model.dto.RestaurantDto;
import com.example.diningreview.service.RestaurantService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.h2.util.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class RestaurantControllerTest {
    @Mock
    private RestaurantService service;

    @InjectMocks
    private RestaurantController controller;
    private MockMvc mockMvc;
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(controller)
                //MockMvc가 Pageable 객체를 controller 메서드의 매개변수로 올바르게 주입하도록 도와준다.
                .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
                .build();
        objectMapper = new ObjectMapper();
    }

    @Test
    @Transactional
    public void shouldCreateRestaurantWithValidData() throws Exception{

        RestaurantDto restaurantDto = RestaurantDto.builder()
                .name("name")
                .type(CuisineType.KOREAN)
                .address("123 st")
                .state("VA")
                .zipCode("12345")
                .phone("123-456-7890")
                .website("restaurant.com")
                .peanutScore(4.0f)
                .dairyScore(2.5f)
                .eggScore(5.0f)
                .overallScore(4.0f)
                .build();

        //어떤 DTO 객체가 와도 true를 반환하도록 설정한다.
        doReturn(true).when(service).validateRestaurant(any(RestaurantDto.class));

        mockMvc.perform(
                post("/restaurant")
                        .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(restaurantDto)))
                .andExpect(status().isOk());
    }

    @Test
    @Transactional
    public void shouldReturnBadRequestWhenInvalidData() throws Exception {

        RestaurantDto restaurantDto = RestaurantDto.builder().build();

        doReturn(false).when(service).validateRestaurant(any(RestaurantDto.class));

        mockMvc.perform(
                post("/restaurant")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(restaurantDto))
        ).andExpect(status().isBadRequest());
    }

    @Test
    public void getAllRestaurantTest() throws Exception {
        int page = 0;
        int size = 10;

        List<RestaurantDto> restaurantDtoList = new ArrayList<>();
        for(int i=0; i<10; i++){
            RestaurantDto restaurantDto = RestaurantDto.builder()
                    .name("name")
                    .type(CuisineType.KOREAN)
                    .address("address")
                    .state("state")
                    .zipCode("zipcode")
                    .phone("123-456-7890")
                    .website("restaurant.com")
                    .peanutScore(4.0f)
                    .dairyScore(2.5f)
                    .eggScore(5.0f)
                    .overallScore(4.0f)
                    .build();
            restaurantDtoList.add(restaurantDto);
        }
        Pageable pageable = PageRequest.of(page, size);  // 테스트에 사용할 Pageable 객체
        Page<RestaurantDto> restaurantDtoPage = new PageImpl<>(restaurantDtoList, pageable, restaurantDtoList.size());

        when(service.getAllRestaurant(page, size))
                .thenReturn(restaurantDtoPage);

        mockMvc.perform(
                get("/restaurant")
                    .param("page", String.valueOf(page))
                    .param("size", String.valueOf(size))
        ).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.size").value(10))
                .andExpect(jsonPath("$.content[0].name").value("name"));
    }
}
