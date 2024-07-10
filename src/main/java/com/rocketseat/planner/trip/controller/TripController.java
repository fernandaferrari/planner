package com.rocketseat.planner.trip.controller;

import com.rocketseat.planner.participant.service.ParticipantService;
import com.rocketseat.planner.trip.dto.TripRequestPayloadDTO;
import com.rocketseat.planner.trip.entity.Trip;
import com.rocketseat.planner.trip.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trips")
public class TripController {

    @Autowired
    ParticipantService participantService;
    @Autowired
    private TripRepository tripRepository;

    @PostMapping("/trips")
    public ResponseEntity<String> createTrip(@RequestBody TripRequestPayloadDTO dto){
        Trip newTrip = new Trip(dto);

        this.tripRepository.save(newTrip);

        this.participantService.registerParticipantsToEvent(dto.emails_to_invite(), newTrip.getId());

        return ResponseEntity.ok("Sucesso");
    }
}
