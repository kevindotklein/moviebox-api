package app.moviebox.series.controller;

import app.moviebox.series.dto.SeriesResponse;
import app.moviebox.series.service.GetSeriesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/series")
@RequiredArgsConstructor
@Tag(name = "series")
public class GetSeriesController {

    private final GetSeriesService getSeriesService;

    @Operation(security = @SecurityRequirement(name = "bearerAuth"))
    @GetMapping
    public ResponseEntity<List<SeriesResponse>> get(@RequestParam(name = "genre", required = false) String genre) {
        return new ResponseEntity<>(getSeriesService.execute(genre), HttpStatus.OK);
    }
}
