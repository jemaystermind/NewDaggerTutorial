package dev.jemaystermind.dagger.tutorial;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;

@Module
abstract class UserCommandModule {

  @Binds
  @IntoMap
  @StringKey("deposit")
  abstract Command depositCommand(DepositCommand command);
}
