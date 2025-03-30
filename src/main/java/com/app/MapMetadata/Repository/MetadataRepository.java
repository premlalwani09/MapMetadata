package com.app.MapMetadata.Repository;

import com.app.MapMetadata.Model.Metadata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MetadataRepository extends JpaRepository<Metadata, String> {

    @Query("SELECT m.type, COUNT(m) FROM Metadata m GROUP BY m.type")
    List<Object[]> countValidPointsByType();

    @Query("SELECT m.type, AVG(m.rating) FROM Metadata m WHERE m.rating IS NOT NULL GROUP BY m.type")
    List<Object[]> averageRatingByType();

    @Query("SELECT m FROM Metadata m WHERE m.reviews = (SELECT MAX(m2.reviews) FROM Metadata m2)")
    Metadata findHighestReviewedLocation();

    @Query("SELECT m FROM Metadata m WHERE m.rating IS NULL OR m.reviews IS NULL")
    List<Metadata> findIncompleteData();

}
