package org.example.annotations;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class MyDictionaryTest {

    @Mock
    Map<String, String> wordMap;

    @InjectMocks
    @Spy
    MyDictionary dic = new MyDictionary();

    @Test
    public void whenUseInjectMocksAnnotation_thenCorrect() {
        Mockito.when(wordMap.get("aWord")).thenReturn("aMeaning");

        MockingDetails mockingDetails = Mockito.mockingDetails(dic);
        System.out.println(mockingDetails.isMock());
        System.out.println(mockingDetails.isSpy());
        Mockito.doNothing().when(dic).tt();
        dic.tt();

        assertEquals("aMeaning", dic.getMeaning("aWord"));
    }
}