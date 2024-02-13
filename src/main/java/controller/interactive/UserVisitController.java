package controller.interactive;

import controller.service.UserInteractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/user")
public class UserVisitController {

    private final UserInteractionService userInteractionService;

    @Autowired
    public UserVisitController(UserInteractionService userInteractionService) {
        this.userInteractionService = userInteractionService;
    }

    @PostMapping("/visit")
    public ResponseEntity<String> recordUserVisit(@RequestParam Long visitorId, @RequestParam Long visitedUserId) {
        try {
            userInteractionService.recordUserVisit(visitorId, visitedUserId);
            return new ResponseEntity<>("Visit recorded successfully", HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


}
