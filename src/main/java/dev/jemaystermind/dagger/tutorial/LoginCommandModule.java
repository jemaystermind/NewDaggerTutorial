package dev.jemaystermind.dagger.tutorial;

import dagger.Binds;
import dagger.Module;

@Module
abstract class LoginCommandModule {

  @Binds
  abstract Command loginCommand(LoginCommand command);
}
