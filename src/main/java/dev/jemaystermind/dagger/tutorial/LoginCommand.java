package dev.jemaystermind.dagger.tutorial;

import javax.inject.Inject;

final class LoginCommand extends SingleArgCommand {
  private final Outputter outputter;

  @Inject
  public LoginCommand(Outputter outputter) {
    this.outputter = outputter;
  }

  @Override protected Result handleArg(String username) {
    outputter.output(username + " is logged in.");
    return Result.handled();
  }
}
