package dev.jemaystermind.dagger.tutorial;

import dagger.Component;
import javax.inject.Singleton;

@Singleton
@Component(modules = {
    HelloWorldModule.class,
    LoginCommandModule.class,
    UserCommandsRouter.InstallationModule.class,
    AmountsModule.class,
    SystemOutModule.class
})
interface CommandProcessorFactory {
  CommandProcessor processor();
}
