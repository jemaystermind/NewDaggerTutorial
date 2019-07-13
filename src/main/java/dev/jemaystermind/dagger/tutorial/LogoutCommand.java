package dev.jemaystermind.dagger.tutorial;

import java.util.List;
import javax.inject.Inject;

import static dev.jemaystermind.dagger.tutorial.Database.*;

final class LogoutCommand implements Command {
  private final Outputter outputter;
  private final Account account;

  @Inject
  public LogoutCommand(Outputter outputter,
      Account account) {
    this.outputter = outputter;
    this.account = account;
  }

  @Override public Result handleInput(List<String> input) {
    if (!input.isEmpty()) {
      return Result.invalid();
    }

    outputter.output("logged out " + account.username());
    return Result.inputCompleted();
  }
}
