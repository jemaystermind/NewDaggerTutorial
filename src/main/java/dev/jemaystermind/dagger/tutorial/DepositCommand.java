package dev.jemaystermind.dagger.tutorial;

import java.math.BigDecimal;
import java.util.List;
import javax.inject.Inject;

import static dev.jemaystermind.dagger.tutorial.Database.*;

class DepositCommand implements Command {

  private final Database database;
  private final Outputter outputter;

  @Inject
  public DepositCommand(Database database, Outputter outputter) {
    System.out.println("Creating a new " + this);
    this.database = database;
    this.outputter = outputter;
  }

  @Override public Result handleInput(List<String> input) {
    if (input.size() != 2) {
      return Result.invalid();
    }

    Account account = database.getAccount(input.get(0));
    account.deposit(new BigDecimal(input.get(1)));
    outputter.output(account.username() + " now has: " + account.balance());
    return Result.handled();
  }
}
