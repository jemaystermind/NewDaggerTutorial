package dev.jemaystermind.dagger.tutorial;

import dagger.Component;

@Component(modules = {HelloWorldModule.class, LoginCommandModule.class, SystemOutModule.class})
interface CommandRouterFactory {
  CommandRouter router();
}
