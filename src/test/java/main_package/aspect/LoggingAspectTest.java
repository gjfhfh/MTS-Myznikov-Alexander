package main_package.aspect;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import main_package.controller.ClientController;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AspectTest {

    @LocalServerPort private int port;

    @Autowired private TestRestTemplate restTemplate;
    @Autowired private ClientController clientController;

    @Test
    void shouldIncreaseClassFieldByTwo() {
        int fieldValueBeforeExecution = clientController.getField();
        String randomUrlRequest =
                restTemplate.getForObject("http://localhost:" + port + "/client/random-url", String.class);
        System.out.println(randomUrlRequest);

        assertEquals(fieldValueBeforeExecution + 2, clientController.getField());
    }
}
