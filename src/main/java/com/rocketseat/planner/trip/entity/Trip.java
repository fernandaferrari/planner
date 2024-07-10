package com.rocketseat.planner.trip.entity;

import com.rocketseat.planner.trip.dto.TripRequestPayloadDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = "destination", nullable = false)
    private String destination;
    @Column(name = "starts_at", nullable = false)
    private LocalDateTime startsAt;
    @Column(name = "ends_at", nullable = false)
    private LocalDateTime endsAt;
    @Column(name = "is_confirmed", nullable = false)
    private boolean isConfirmed;
    @Column(name = "owner_name", nullable = false)
    private String ownerName;
    @Column(name = "owner_email", nullable = false)
    private String ownerEmail;

    public Trip(){}
    public Trip(TripRequestPayloadDTO dto) {
        this.destination=dto.destination();
        this.startsAt= LocalDateTime.parse(dto.starts_at(), DateTimeFormatter.ISO_DATE_TIME);
        this.endsAt=LocalDateTime.parse(dto.ends_at(), DateTimeFormatter.ISO_DATE_TIME);
        this.isConfirmed=false;
        this.ownerEmail=dto.owner_email();
        this.ownerName=dto.owner_name();
    }


}