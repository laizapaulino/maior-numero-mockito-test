package com.laipim.maiornumeromockitotest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BusinessServicesMockTest {
    //Cria simulação para dataService e injeta simulações para businessService
    @Mock
    DataService dataServiceMock;

    @InjectMocks
    BusinessService businessImpl;

    @Test
    public void encontraMaiorListaComMaisDeUm() {
        when(dataServiceMock.recuperaTodosOsDados()).thenReturn(new int[] { 24, 15, 3 });
        assertEquals(24, businessImpl.encontraOMaior());
    }

    @Test
    public void encontraMaiorListaComUm() {
        when(dataServiceMock.recuperaTodosOsDados()).thenReturn(new int[] { 15 });
        assertEquals(15, businessImpl.encontraOMaior());
    }

    @Test
    public void encontraMaiorListaVazia() {
        when(dataServiceMock.recuperaTodosOsDados()).thenReturn(new int[] {});
        assertEquals(Integer.MIN_VALUE, businessImpl.encontraOMaior());
    }
}