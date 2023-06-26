package section4.optionalAPI;

import java.time.Duration;

public class Progress {
    private Duration studyDuration;
    private boolean finished;

    public Duration getStudyDuration() {
        return studyDuration;
    }

    public void setStudyDuration(Duration studyDuration) {
        this.studyDuration = studyDuration;
    }
}
