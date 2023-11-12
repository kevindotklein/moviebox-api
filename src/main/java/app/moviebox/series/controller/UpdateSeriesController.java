package app.moviebox.series.controller;

import app.moviebox.series.dto.SeriesRequest;
import app.moviebox.series.dto.SeriesResponse;
import app.moviebox.series.service.UpdateSeriesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/series")
@RequiredArgsConstructor
@Tag(name = "series")
public class UpdateSeriesController {

    private final UpdateSeriesService updateSeriesService;

    @Operation(security = @SecurityRequirement(name = "bearerAuth"))
    @PutMapping("/{seriesId}")
    public ResponseEntity<SeriesResponse> updateSeries(@PathVariable UUID seriesId,
                                                       @RequestBody @Valid SeriesRequest request,
                                                       Authentication auth) {
        UserDetails principal = (UserDetails) auth.getPrincipal();
        return new ResponseEntity<>(updateSeriesService.execute(seriesId, request, principal.getUsername())
                , HttpStatus.OK);
    }

}
