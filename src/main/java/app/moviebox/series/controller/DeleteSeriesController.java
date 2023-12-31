package app.moviebox.series.controller;

import app.moviebox.series.dto.SeriesResponse;
import app.moviebox.series.service.DeleteSeriesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/series")
@RequiredArgsConstructor
@Tag(name = "series")
public class DeleteSeriesController {

    private final DeleteSeriesService deleteSeriesService;

    @Operation(security = @SecurityRequirement(name = "bearerAuth"))
    @DeleteMapping("/{seriesId}")
    public ResponseEntity<SeriesResponse> deleteSeries(@PathVariable UUID seriesId, Authentication auth) {
        UserDetails principal = (UserDetails) auth.getPrincipal();
        return new ResponseEntity<>(deleteSeriesService.execute(seriesId, principal.getUsername()), HttpStatus.OK);
    }
}
