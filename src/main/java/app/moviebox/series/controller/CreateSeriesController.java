package app.moviebox.series.controller;

import app.moviebox.series.dto.SeriesRequest;
import app.moviebox.series.dto.SeriesResponse;
import app.moviebox.series.service.CreateSeriesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/series")
@RequiredArgsConstructor
@Tag(name = "series")
public class CreateSeriesController {

    private final CreateSeriesService createSeriesService;

    @Operation(security = @SecurityRequirement(name = "bearerAuth"))
    @PostMapping
    public ResponseEntity<SeriesResponse> createSeries(@RequestBody @Valid SeriesRequest request,
                                                       Authentication auth) {
        UserDetails principal = (UserDetails) auth.getPrincipal();
        return new ResponseEntity<>(createSeriesService.execute(request, principal.getUsername()), HttpStatus.CREATED);
    }

}
