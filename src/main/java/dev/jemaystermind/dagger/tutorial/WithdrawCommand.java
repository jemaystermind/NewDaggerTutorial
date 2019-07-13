package dev.jemaystermind.dagger.tutorial;

import dev.jemaystermind.dagger.tutorial.Database.Account;
import java.math.BigDecimal;
import javax.inject.Inject;

final class WithdrawCommand extends BigDecimalCommand {
  private final Outputter outputter;
  private final Account account;
  private BigDecimal minBalance;
  private BigDecimal maxWithdrawal;
  private WithdrawalLimiter withdrawalLimiter;

  @Inject
  public WithdrawCommand(
      Outputter outputter,
      Account account,
      @MinimumBalance BigDecimal minBalance,
      @MaximumWithdrawal BigDecimal maxWithdrawal,
      WithdrawalLimiter withdrawalLimiter) {
    super(outputter);
    this.outputter = outputter;
    this.account = account;
    this.minBalance = minBalance;
    this.maxWithdrawal = maxWithdrawal;
    this.withdrawalLimiter = withdrawalLimiter;
  }

  @Override protected void handleAmount(BigDecimal amount) {
    BigDecimal remainingWithdrawalLimit = withdrawalLimiter.remainingWithdrawalLimit();
    if (amount.compareTo(remainingWithdrawalLimit) > 0) {
      outputter.output(
          String.format("you may not withdraw %s; maximum withdrawal is %s", amount, remainingWithdrawalLimit)
      );
      return;
    }

    BigDecimal newBalance = account.balance().subtract(amount);
    if (newBalance.compareTo(minBalance) < 0) {
      outputter.output(
          String.format("your balance is %s and the minimum balance is %s", account.balance(), minBalance)
      );
    } else {
      account.withdraw(amount);
      withdrawalLimiter.recordWithdrawal(amount);
      outputter.output("your new balance is: " + account.balance());
    }
  }
}
