package com.app.MapMetadata.Service;

import com.app.MapMetadata.Model.Location;
import com.app.MapMetadata.Model.Metadata;
import com.app.MapMetadata.Repository.LocationRepository;
import com.app.MapMetadata.Repository.MetadataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class MapDataService {


    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private MetadataRepository metadataRepository;



    // Save Locations Data
    public void saveLocations(List<Location> locations) {
        locationRepository.saveAll(locations);
    }

    // Save Metadata Data
    public void saveAllMetadata(List<Metadata> metadataList) {
        metadataRepository.saveAll(metadataList);
    }

    // Consolidated Evaluation Report
    public Map<String, Object> getEvaluationReport() {
        Map<String, Object> report = new HashMap<>();

        // Count valid points per type
        Map<String, Long> validPoints = metadataRepository.countValidPointsByType()
                .stream().collect(Collectors.toMap(o -> (String) o[0], o -> (Long) o[1]));
        report.put("validPointsPerType", validPoints);

        // Average rating per type
        Map<String, Double> avgRatings = metadataRepository.averageRatingByType()
                .stream().collect(Collectors.toMap(o -> (String) o[0], o -> (Double) o[1]));
        report.put("averageRatingPerType", avgRatings);

        // Highest reviewed location
        Metadata highestReviewed = metadataRepository.findHighestReviewedLocation();
        report.put("highestReviewedLocation", highestReviewed);

        // Incomplete data locations
        List<Metadata> incompleteData = metadataRepository.findIncompleteData();
        report.put("incompleteData", incompleteData);

        return report;
    }

}
