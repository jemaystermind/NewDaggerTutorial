package dev.jemaystermind.dagger.tutorial;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;

import static dev.jemaystermind.dagger.tutorial.Command.Status;

final class CommandRouter {
  private final Map<String, Command> commands = new HashMap<>();

  @Inject
  public CommandRouter(HelloWorldCommand helloWorldCommand) {
    commands.put(helloWorldCommand.key(), helloWorldCommand);
  }

  Status route(String input) {
    List<String> splitInput = split(input);
    if (splitInput.isEmpty()) {
      return invalidCommand(input);
    }

    String commandKey = splitInput.get(0);
    Command command = commands.get(commandKey);
    if (command == null) {
      return invalidCommand(input);
    }

    Status status = command.handleInput(splitInput.subList(1, splitInput.size()));
    if (status == Status.INVALID) {
      System.out.println(commandKey + ": invalid arguments");
      return status;
    }

    return status;
  }

  private Status invalidCommand(String input) {
    System.out.println(String.format("Could not understand \"%s\". Please try again.", input));
    return Status.INVALID;
  }

  private List<String> split(String input) {
    return Arrays.asList(input.trim().split("\\s+"));
  }
}
