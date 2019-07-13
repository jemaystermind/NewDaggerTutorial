package dev.jemaystermind.dagger.tutorial;

import dagger.BindsInstance;
import dagger.Module;
import dagger.Subcomponent;

import static dev.jemaystermind.dagger.tutorial.Database.Account;

@Subcomponent(
    modules = {
        UserCommandModule.class
    }
)
interface UserCommandsRouter {
  CommandRouter router();

  @Subcomponent.Factory
  interface Factory {
    UserCommandsRouter create(@BindsInstance Account account);
  }

  @Module(subcomponents = UserCommandsRouter.class)
  interface InstallationModule {

  }
}
