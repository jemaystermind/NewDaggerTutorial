package dev.jemaystermind.dagger.tutorial;

import java.util.ArrayDeque;
import java.util.Deque;
import javax.inject.Inject;
import javax.inject.Singleton;

import static dev.jemaystermind.dagger.tutorial.Command.Result;
import static dev.jemaystermind.dagger.tutorial.Command.Status;

@Singleton
public class CommandProcessor {
  private final Deque<CommandRouter> commandRouterTask = new ArrayDeque<>();

  @Inject
  public CommandProcessor(CommandRouter firstCommandRouter) {
    commandRouterTask.push(firstCommandRouter);
  }

  Status process(String input) {
    Result result = commandRouterTask.peek().route(input);
    if (result.status().equals(Status.INPUT_COMPLETED)) {
      commandRouterTask.pop();
      return commandRouterTask.isEmpty() ? Status.INPUT_COMPLETED : Status.HANDLED;
    }

    result.nestedCommandRouter().ifPresent(commandRouterTask::push);
    return result.status();
  }
}
