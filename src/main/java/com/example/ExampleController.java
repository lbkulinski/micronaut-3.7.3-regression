package com.example;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Produces;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;

import java.net.URI;

@Controller("/api/example")
@Secured(SecurityRule.IS_AUTHENTICATED)
public class ExampleController {
    @Post
    @Produces(MediaType.APPLICATION_JSON)
    public HttpResponse<?> create() {
        String locationString = "http://localhost:8080/api/example/1";

        URI location = URI.create(locationString);

        return HttpResponse.created(location);
    } //create
}