package controller.interactive;

import controller.service.UserInteractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserLikeController {

    private final UserInteractionService userInteractionService;

    @Autowired
    public UserLikeController(UserInteractionService userInteractionService) {
        this.userInteractionService = userInteractionService;
    }

    @PostMapping("/like")
    public ResponseEntity<String> recordUserLike(@RequestParam Long likerId, @RequestParam Long likedUserId) {
        try {
            userInteractionService.recordUserLike(likerId, likedUserId);
            return new ResponseEntity<>("Like recorded successfully", HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
