package main_package.response;

import main_package.model.University;

public record UserGetResponse(String fullname, University university) {}
