
package controller;

public class PeriodicityGenerator {
    private Integer fps = 60;
    private long msPerFrame = 1000 / fps;
    private long prevTime = 0;

    public void setFps(final Integer fps) {
        this.fps = fps;
        this.msPerFrame = 1000 / fps;
    }

    public boolean elapsed() {
        final long currentTime = System.currentTimeMillis();
        final long elapsedTime = currentTime - this.prevTime;
        if ( this.msPerFrame < elapsedTime ) {
            this.prevTime = currentTime - ( elapsedTime % this.msPerFrame );
            return true;
        }
        return false;
    }
}