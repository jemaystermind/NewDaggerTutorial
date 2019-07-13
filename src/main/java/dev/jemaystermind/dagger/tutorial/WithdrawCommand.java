package dev.jemaystermind.dagger.tutorial;

import dev.jemaystermind.dagger.tutorial.Database.Account;
import java.math.BigDecimal;
import javax.inject.Inject;

final class WithdrawCommand extends BigDecimalCommand {
  private final Outputter outputter;
  private final Account account;

  @Inject
  public WithdrawCommand(Outputter outputter, Account account) {
    super(outputter);
    this.outputter = outputter;
    this.account = account;
  }

  @Override protected void handleAmount(BigDecimal amount) {
    BigDecimal newBalance = account.balance().subtract(amount);
    if (newBalance.signum() < 0) {
      // Output error.
      return;
    } else {
      account.withdraw(amount);
      outputter.output("your new balance is: " + account.balance());
    }
  }
}
