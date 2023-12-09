
package controller;

public class PeriodicityGenerator {
    private Integer fps = 12;
    private long msPerFrame = 1000 / fps;
    private long prevTime = 0;

    public void setFps(final Integer fps) {
        this.fps = fps;
        this.msPerFrame = 1000 / fps;
    }

    public boolean elapsed() {
        final long currentTime = System.currentTimeMillis();
        final long elapsedTime = currentTime - this.prevTime;
        if (this.msPerFrame < elapsedTime) {
            this.prevTime = currentTime - (elapsedTime % this.msPerFrame);
            return true;
        }
        return false;
    }

    public long remainedTime() {
        final long currentTime = System.currentTimeMillis();
        final long elapsedTime = currentTime - this.prevTime;
        long remainedTime = this.msPerFrame - elapsedTime;
        if (remainedTime < 0) {
            remainedTime = 0;
        }
        this.prevTime = currentTime;
        return remainedTime;
    }
}