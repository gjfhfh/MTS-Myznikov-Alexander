package main_package.controller;

import main_package.model.BookData;
import main_package.request.BookCreateRequest;
import main_package.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = BookController.class)
class BookControllerImplTest {
    @Autowired
    private MockMvc mockMvc;
    @MockitoBean
    private BookService bookService;
    @Test
    void getAllBooksById() throws Exception {
        Long mockId = 1L;
        List<BookData> mockBookData = new ArrayList<BookData>();
        mockBookData.add(new BookData("Тест", "Тест", 52));
        when(bookService.getAllBooksById(mockId)).thenReturn((ArrayList<BookData>) mockBookData);

        mockMvc.perform(get("http://localhost:8080/api/book/user/1")).andExpect(status().isOk());
    }

    @Test
    void addBookForUserById() throws Exception {
        BookCreateRequest request = new BookCreateRequest("Тест", "Тест", 52);
        doNothing().when(bookService.createBook(request));

        mockMvc.perform(get("http://localhost:8080/api/book/user/1")).andExpect(status().isOk());
    }

    @Test
    void getAllBooksById_NotFound() throws Exception {
        Long mockId = 1L;
        when(bookService.getAllBooksById(mockId)).thenThrow(new RuntimeException("Books not found"));

        mockMvc.perform(get("http://localhost:8080/api/book/user/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    void addBookForUserById_BadRequest() throws Exception {
        BookCreateRequest request = new BookCreateRequest("", "", 0); // Неверные данные
        doThrow(new IllegalArgumentException("Invalid book data")).when(bookService).createBook(request);

        mockMvc.perform(post("http://localhost:8080/api/book/user/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"title\":\"\", \"author\":\"\", \"year\":0}"))
                .andExpect(status().isBadRequest());
    }
}
