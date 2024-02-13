package controller.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;


public class ProfileVisit {

    private Long visitId;
    private Long visitorId;
    private Long visitedUserId;
    private String visitorUsername;
    private LocalDateTime visitTimestamp;

    @Override
    public String toString() {
        return "ProfileVisit{" +
                "visitId='" + visitId + '\'' +
                "visitorId='" + visitorId + '\'' +
                "visitedUserId='" + visitedUserId + '\'' +
                "visitorUsername='" + visitorUsername + '\'' +
                "visitTimestamp='" + visitTimestamp + '\'' +
                '}';
    }


    public Long getVisitId() {
        return visitId;
    }

    public void setVisitId(Long visitId) {
        this.visitId = visitId;
    }

    public String getVisitorUsername() {
        return visitorUsername;
    }

    public void setVisitorUsername(String visitorUsername) {
        this.visitorUsername = visitorUsername;
    }

    public Long getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(Long visitorId) {
        this.visitorId = visitorId;
    }

    public Long getVisitedUserId() {
        return visitedUserId;
    }

    public void setVisitedUserId(Long visitedUserId) {
        this.visitedUserId = visitedUserId;
    }

    public LocalDateTime getVisitTimestamp() {
        return visitTimestamp;
    }

    public void setVisitTimestamp(LocalDateTime visitTimestamp) {
        this.visitTimestamp = visitTimestamp;
    }



}

