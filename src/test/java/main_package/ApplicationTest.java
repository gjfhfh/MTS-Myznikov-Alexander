package main_package;

import main_package.response.BookGetResponse;
import main_package.response.UniversityGetResponse;
import main_package.response.UserGetResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ApplicationTest {
    @LocalServerPort

    private int port;
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testHomePage() {
        ResponseEntity<List> response0 = restTemplate.getForEntity("http://localhost:" + port + "/" + "api/course/user/1", List.class);
        assertEquals(HttpStatus.OK, response0.getStatusCode());
        ResponseEntity<UniversityGetResponse> response1 = restTemplate.getForEntity("http://localhost:" + port + "/" + "api/university/user/1", UniversityGetResponse.class);
        assertEquals(HttpStatus.OK, response1.getStatusCode());
        ResponseEntity<List> response2 = restTemplate.getForEntity("http://localhost:" + port + "/" + "api/book/user/1", List.class);
        assertEquals(HttpStatus.OK, response2.getStatusCode());
        ResponseEntity<UserGetResponse> response3 = restTemplate.getForEntity("http://localhost:" + port + "/" + "api/user/1", UserGetResponse.class);
        assertEquals(HttpStatus.OK, response3.getStatusCode());
        ResponseEntity<UserGetResponse> response4 = restTemplate.getForEntity("http://localhost:" + port + "/" + "api/user/2", UserGetResponse.class);
        assertEquals(HttpStatus.BAD_REQUEST, response4.getStatusCode());
        ResponseEntity<UserGetResponse> response5 = restTemplate.getForEntity("http://localhost:" + port + "/" + "api/user/2", UserGetResponse.class);
        assertEquals(HttpStatus.NOT_FOUND, response5.getStatusCode());

    }
}
