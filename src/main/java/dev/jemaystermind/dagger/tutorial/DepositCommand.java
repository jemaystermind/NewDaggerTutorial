package dev.jemaystermind.dagger.tutorial;

import java.math.BigDecimal;
import javax.inject.Inject;

import static dev.jemaystermind.dagger.tutorial.Database.Account;

class DepositCommand extends BigDecimalCommand {

  private final Account account;
  private final Outputter outputter;

  @Inject
  public DepositCommand(Account account, Outputter outputter) {
    super(outputter);
    this.account = account;
    this.outputter = outputter;
  }


  @Override protected void handleAmount(BigDecimal amount) {
    account.deposit(amount);
    outputter.output(account.username() + " now has: " + account.balance());
  }
}
