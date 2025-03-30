package com.app.MapMetadata.Controller;

import com.app.MapMetadata.Model.Location;
import com.app.MapMetadata.Model.Metadata;
import com.app.MapMetadata.Service.MapDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/mapdata")
public class MapDataController {


    @Autowired
    private MapDataService mapDataService;



    // Add Single or Multiple Locations
    @PostMapping("/location")
    public ResponseEntity<String> addLocation(@RequestBody List<Location> locations) {
        mapDataService.saveLocations(locations);
        return ResponseEntity.ok("Locations added successfully!");
    }

    // Add Single or Multiple Metadata Entries
    @PostMapping("/metadata")
    public ResponseEntity<String> addMetadata(@RequestBody List<Metadata> metadataList) {
        mapDataService.saveAllMetadata(metadataList);
        return ResponseEntity.ok("Metadata added successfully!");
    }

    // Get Evaluation Report
    @GetMapping("/evaluation")
    public ResponseEntity<Map<String, Object>> getEvaluationData() {
        Map<String, Object> report = mapDataService.getEvaluationReport();
        return ResponseEntity.ok(report);
    }

}
