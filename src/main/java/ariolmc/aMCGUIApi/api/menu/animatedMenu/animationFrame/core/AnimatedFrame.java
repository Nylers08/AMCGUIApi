package ariolmc.aMCGUIApi.api.menu.animatedMenu.animationFrame.core;

import ariolmc.aMCGUIApi.api.menu.menu.Menu;

import java.util.List;

/**
 * Анимированный кадр, хранит в себе другие AnimationFrame.
 * AnimationFrame, при этом может быть как статичный кадр, или другой анимированный кадр
 */
public class AnimatedFrame implements AnimationFrame {

    private boolean isAnimationFinished = false;
    private final List<AnimationFrame> frames;
    private int currentFrameIndex;

    private final int repeatCount;
    private int repeatDone = 0;

    /**
     * @param frames Список кадров для анимации
     * @param repeatCount кол-вол повторений проигрывания кадра. -1 для бесконечного цикла проигрывания
     */
    public AnimatedFrame(List<AnimationFrame> frames, int repeatCount){
        this.frames = frames;
        currentFrameIndex = 0;
        this.repeatCount = repeatCount;
    }

    /**
     * Один раз проиграет анимацию
     * @param frames Список кадров для анимации
     */
    public AnimatedFrame(List<AnimationFrame> frames){
        this(frames, 1);
    }


    @Override
    public void tick() {
        if(isAnimationFinished)
            return;

        tickCurrentFrame();
        stepIfFinished();
    }

    @Override
    public boolean isAnimationFinished() {
        return isAnimationFinished;
    }

    @Override
    public Menu getCurrentMenu() {
        return getCurrentFrame().getCurrentMenu();
    }

    /**
     * Обновить все вложенные анимации
     */
    @Override
    public void reset() {
        currentFrameIndex = 0;
        isAnimationFinished = false;
        framesReset();
        repeatDone = 0;
    }

    private void framesReset(){
        frames.forEach(AnimationFrame::reset);
    }


    public AnimationFrame getCurrentFrame(){
        return frames.get(currentFrameIndex);
    }


    private void tickCurrentFrame(){
        getCurrentFrame().tick();
    }

    private void stepIfFinished(){
        if(getCurrentFrame().isAnimationFinished()) {
            frameStep();
        }
    }

    private void frameStep(){
        currentFrameIndex++;
        if(areFramesFinished()){
            currentFrameIndex = 0;
            repeatDone++;
            framesReset();
            checkRepeatCompletion();
        }
    }

    private boolean areFramesFinished(){
        return currentFrameIndex>=frames.size();
    }

    private void checkRepeatCompletion(){
        if(repeatDone == repeatCount) {
            isAnimationFinished = true;
            repeatDone = 0;
        }
    }
}
