package bg.softuni.linkedout.util;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class LastUpdated {
    private LocalDateTime lastUpdate;

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
