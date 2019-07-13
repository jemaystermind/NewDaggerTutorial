package dev.jemaystermind.dagger.tutorial;

import java.math.BigDecimal;
import javax.inject.Inject;

@PerSession
final class WithdrawalLimiter {
  private BigDecimal remainingWithdrawalLimit;

  @Inject
  public WithdrawalLimiter(@MaximumWithdrawal BigDecimal remainingWithdrawalLimit) {
    this.remainingWithdrawalLimit = remainingWithdrawalLimit;
  }

  public BigDecimal remainingWithdrawalLimit() {
    return remainingWithdrawalLimit;
  }

  void recordDeposit(BigDecimal amount) {
    remainingWithdrawalLimit = remainingWithdrawalLimit.add(amount);
  }

  void recordWithdrawal(BigDecimal amount) {
    remainingWithdrawalLimit = remainingWithdrawalLimit.subtract(amount);
  }
}
