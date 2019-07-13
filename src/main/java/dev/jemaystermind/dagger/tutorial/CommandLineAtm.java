package dev.jemaystermind.dagger.tutorial;

import java.util.Scanner;

public class CommandLineAtm {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    CommandProcessorFactory commandRouterFactory = DaggerCommandProcessorFactory.create();
    CommandProcessor commandRouter = commandRouterFactory.processor();
    while (scanner.hasNextLine()) {
      commandRouter.process(scanner.nextLine());
    }
  }
}
