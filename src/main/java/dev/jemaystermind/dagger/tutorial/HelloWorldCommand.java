package dev.jemaystermind.dagger.tutorial;

import java.util.List;
import javax.inject.Inject;

public class HelloWorldCommand implements Command {

  private final Outputter outputter;

  @Inject
  public HelloWorldCommand(Outputter outputter) {
    this.outputter = outputter;
  }

  @Override public String key() {
    return "hello";
  }

  @Override public Result handleInput(List<String> input) {
    if (!input.isEmpty()) {
      return Result.invalid();
    }

    outputter.output("world!");
    return Result.handled();
  }
}
