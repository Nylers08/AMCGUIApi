package ariolmc.aMCGUIApi.core.menu.animatedMenu.animationFrame.core;

import ariolmc.aMCGUIApi.core.menu.someMenu.Menu;

import java.util.List;

public class AnimatedFrame implements AnimationFrame {

    private boolean isAnimationFinished = false;
    private final List<AnimationFrame> frames;
    private int currentFrameIndex;

    public AnimatedFrame(List<AnimationFrame> frames){
        this.frames = frames;
        currentFrameIndex = 0;
    }

    @Override
    public void tick() {
        if(isAnimationFinished)
            return;

        tickCurrentFrame();

        if(frames.get(currentFrameIndex).isAnimationFinished()) {
            nextFrameIndex();
        }
    }

    @Override
    public boolean isAnimationFinished() {
        return isAnimationFinished;
    }

    @Override
    public Menu getCurrentMenu() {
        return frames.get(currentFrameIndex).getCurrentMenu();
    }

    @Override
    public void reset() {
        currentFrameIndex = 0;
        isAnimationFinished = false;
        frames.forEach(AnimationFrame::reset);
    }


    private void tickCurrentFrame(){
        AnimationFrame frame = frames.get(currentFrameIndex);
        frame.tick();
    }

    private void nextFrameIndex(){
        currentFrameIndex++;
        if(currentFrameIndex>=frames.size()){
            isAnimationFinished = true;
            currentFrameIndex = 0;
        }
    }
}
