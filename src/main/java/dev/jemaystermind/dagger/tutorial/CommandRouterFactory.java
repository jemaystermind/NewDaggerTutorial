package dev.jemaystermind.dagger.tutorial;

import dagger.Component;

@Component(modules = {LoginCommandModule.class, SystemOutModule.class})
interface CommandRouterFactory {
  CommandRouter router();
}
