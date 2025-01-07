package com.example.myapp.controller;

//import io.swagger.v3.oas.annotations.media.Schema;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;

@RestController
public class MyController {

    @GetMapping("/api/greeting")
    @Operation(summary = "Get Greeting", description = "Returns a greeting message.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Obtained a response.",
                        content = @Content(mediaType = "text/plain"))

    })
    public String getGreeting() {
        return "Hello, World!";
    }

    @PostMapping("/api/submit")
    @Operation(summary = "Submit Data", description = "Receives data and returns a confirmation message.",
                requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                        description = "The data to be submitted",
                        content = @Content(mediaType = "application/json",
                        schema = @Schema(type = "string", example = "Sample data"))))
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Data successfully received."),
            @ApiResponse(responseCode = "400", description = "Bad request, invalid data.")
    })
    public String submitData(@RequestBody String data) {
        return "Data received: " + data;
    }

    @GetMapping("/api/user/{id}")
    @Operation(summary = "Get User ID", description = "Returns an ID from a user.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User Received."),
    })
    public String getUserById(@PathVariable("id") Long id) {
        return "User ID: " + id;
    }

    @GetMapping("/api/search")
    @Operation(summary = "Search", description = "Searches for items based on a query parameter.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful search."),
    })
    public String search(
            @Parameter(name = "query",
                        description = "The search keyword used to search items",
                         example = "laptop")
            @RequestParam(name = "query", defaultValue = "") String query) {
        return "Search results for: " + query;
    }
}
