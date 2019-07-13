package dev.jemaystermind.dagger.tutorial;

import dagger.Component;

@Component(modules = HelloWorldModule.class)
interface CommandRouterFactory {
  CommandRouter router();
}
