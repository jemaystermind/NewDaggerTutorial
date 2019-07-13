package dev.jemaystermind.dagger.tutorial;

import dagger.Module;
import dagger.Provides;

@Module
class SystemOutModule {

  @Provides
  static Outputter textOutputter() {
    return System.out::println;
  }
}
