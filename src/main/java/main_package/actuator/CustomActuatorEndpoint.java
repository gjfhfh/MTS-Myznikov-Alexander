package main_package.actuator;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Endpoint(id = "random-uuid")
public class CustomActuatorEndpoint {

    @ReadOperation
    public String getRandomUUID() {
        return UUID.randomUUID().toString();
    }
}
