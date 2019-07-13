package dev.jemaystermind.dagger.tutorial;

import dev.jemaystermind.dagger.tutorial.Database.Account;
import javax.inject.Inject;


final class LoginCommand extends SingleArgCommand {
  private final Outputter outputter;
  private final Database database;
  private final UserCommandsRouter.Factory userCommandRouterFactory;

  @Inject
  LoginCommand(Database database, Outputter outputter,
      UserCommandsRouter.Factory userCommandRouterFactory) {
    System.out.println("Creating a new " + this);
    this.outputter = outputter;
    this.database = database;
    this.userCommandRouterFactory = userCommandRouterFactory;
  }

  @Override protected Result handleArg(String username) {
    Account account = database.getAccount(username);
    outputter.output(username + " is logged in with balance: " + account.balance());
    return Result.enterNestedCommandSet(userCommandRouterFactory.create(account).router());
  }
}
