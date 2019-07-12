package dev.jemaystermind.dagger.tutorial;

import java.util.List;

/* Logic to process some user input. */
interface Command {

  /**
   * String token that signifies this command should be selected
   * E.g. "deposit", "withdraw".
   */
  String key();

  /** Process the rest of the command's words and do something. */
  Status handleInput(List<String> input);

  enum Status {
    INVALID,
    HANDLED
  }
}
