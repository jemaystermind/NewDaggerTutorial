package dev.jemaystermind.dagger.tutorial;

import dev.jemaystermind.dagger.tutorial.Database.Account;
import java.math.BigDecimal;
import javax.inject.Inject;

final class WithdrawCommand extends BigDecimalCommand {
  private final Outputter outputter;
  private final Account account;
  private BigDecimal minBalance;
  private BigDecimal maxWithdrawal;

  @Inject
  public WithdrawCommand(
      Outputter outputter,
      Account account,
      @MinimumBalance BigDecimal minBalance,
      @MaximumWithdrawal BigDecimal maxWithdrawal) {
    super(outputter);
    this.outputter = outputter;
    this.account = account;
    this.minBalance = minBalance;
    this.maxWithdrawal = maxWithdrawal;
  }

  @Override protected void handleAmount(BigDecimal amount) {
    if (amount.compareTo(maxWithdrawal) > 0) {
      outputter.output(
          String.format("you may not withdraw %s; maximum withdrawal is %s", amount, maxWithdrawal)
      );
      return;
    }

    BigDecimal newBalance = account.balance().subtract(amount);
    if (newBalance.compareTo(minBalance) < 0) {
      outputter.output(
          String.format("your balance is %s and the minimum balance is %s", account.balance(),
              minBalance)
      );
    } else {
      account.withdraw(amount);
      outputter.output("your new balance is: " + account.balance());
    }
  }
}
