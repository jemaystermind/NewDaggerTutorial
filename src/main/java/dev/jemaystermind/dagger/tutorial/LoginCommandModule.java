package dev.jemaystermind.dagger.tutorial;

import dagger.Binds;
import dagger.BindsOptionalOf;
import dagger.Module;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;

import static dev.jemaystermind.dagger.tutorial.Database.*;

@Module
abstract class LoginCommandModule {

  @Binds
  @IntoMap
  @StringKey("login")
  abstract Command loginCommand(LoginCommand command);

  @BindsOptionalOf
  abstract Account optionalAccount();
}
