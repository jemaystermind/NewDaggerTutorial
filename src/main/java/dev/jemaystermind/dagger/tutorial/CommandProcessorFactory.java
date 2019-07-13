package dev.jemaystermind.dagger.tutorial;

import dagger.Component;
import javax.inject.Singleton;

@Singleton
@Component(modules = {
    HelloWorldModule.class,
    LoginCommandModule.class,
    UserCommandModule.class,
    SystemOutModule.class
})
interface CommandProcessorFactory {
  CommandProcessor processor();
}
