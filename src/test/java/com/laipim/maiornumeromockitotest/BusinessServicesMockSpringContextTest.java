package com.laipim.maiornumeromockitotest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest //Indica que vai rodar o contexto do Application
public class BusinessServicesMockSpringContextTest {
    //Simula apenas o data service
    @MockBean
    DataService dataServiceMock;

    @Autowired
    BusinessService businessImpl;

    @Test
    public void encontraMaiorListaComMaisDeUm() {
        when(dataServiceMock.recuperaTodosOsDados()).thenReturn(new int[]{24, 15, 3});
        assertEquals(24, businessImpl.encontraOMaior());
    }

    @Test
    public void encontraMaiorListaComUm() {
        when(dataServiceMock.recuperaTodosOsDados()).thenReturn(new int[]{15});
        assertEquals(15, businessImpl.encontraOMaior());
    }

    @Test
    public void encontraMaiorListaVazia() {
        when(dataServiceMock.recuperaTodosOsDados()).thenReturn(new int[]{});
        assertEquals(Integer.MIN_VALUE, businessImpl.encontraOMaior());
    }
}