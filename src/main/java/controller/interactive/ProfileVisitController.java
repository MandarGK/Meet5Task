package controller.interactive;


import controller.model.ProfileVisit;
import controller.service.ProfileVisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/profile-visits")
public class ProfileVisitController {

    private final ProfileVisitService profileVisitService;

    @Autowired
    public ProfileVisitController(ProfileVisitService profileVisitService) {
        this.profileVisitService = profileVisitService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<ProfileVisit>> getProfileVisits(@PathVariable Long userId) {
        List<ProfileVisit> profileVisits = profileVisitService.getProfileVisitsForUser(userId);
        return ResponseEntity.ok(profileVisits);
    }
}
