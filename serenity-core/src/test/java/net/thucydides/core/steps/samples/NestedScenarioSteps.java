package net.thucydides.core.steps.samples;

import net.thucydides.core.annotations.BlurScreenshots;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.pages.WrongPageError;
import net.thucydides.core.screenshots.BlurLevel;
import net.thucydides.core.steps.ScenarioSteps;

public class NestedScenarioSteps extends ScenarioSteps {

    @Steps
    public FlatScenarioSteps innerSteps;

    public NestedScenarioSteps(Pages pages) {
        super(pages);
    }

    @Step
    public void step1() throws WrongPageError {
        innerSteps.step_one();
        innerSteps.step_two();
        innerSteps.step_three();
    }
    
    @Step
    public void step2() throws WrongPageError {
        innerSteps.step_one();
        innerSteps.step_three();
    }

    @Step
    public void step3() throws WrongPageError {
    }

    @Step
    public void nestedFailingStep() {
        innerSteps.failingStep();
    }

    @Step
    public void step_with_nested_failure() throws WrongPageError {
        innerSteps.step_one();
        innerSteps.failingStep();
    }

    @Step
    @BlurScreenshots(BlurLevel.HEAVY)
    public void blurred_step() {
    }
}
