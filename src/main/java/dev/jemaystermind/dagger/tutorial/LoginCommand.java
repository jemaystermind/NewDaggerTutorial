package dev.jemaystermind.dagger.tutorial;

import dev.jemaystermind.dagger.tutorial.Database.Account;
import java.util.Optional;
import javax.inject.Inject;

final class LoginCommand extends SingleArgCommand {
  private final Outputter outputter;
  private final Database database;
  private final UserCommandsRouter.Factory userCommandRouterFactory;
  private final Optional<Account> account;

  @Inject
  LoginCommand(
      Database database,
      Outputter outputter,
      UserCommandsRouter.Factory userCommandRouterFactory,
      Optional<Account> account) {
    System.out.println("Creating a new " + this);
    this.outputter = outputter;
    this.database = database;
    this.userCommandRouterFactory = userCommandRouterFactory;
    this.account = account;
  }

  @Override protected Result handleArg(String username) {
    if (account.isPresent()) {
      // Ignore "login <foo>" commands f we already have an account.
      return Result.handled();
    }
    Account account = database.getAccount(username);
    outputter.output(username + " is logged in with balance: " + account.balance());
    return Result.enterNestedCommandSet(userCommandRouterFactory.create(account).router());
  }
}
