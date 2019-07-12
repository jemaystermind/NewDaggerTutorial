package dev.jemaystermind.dagger.tutorial;

import dagger.Component;

@Component
interface CommandRouterFactory {
  CommandRouter router();
}
