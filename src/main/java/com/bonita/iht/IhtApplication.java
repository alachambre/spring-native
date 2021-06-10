package com.bonita.iht;

import com.bonita.iht.best.Mode;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.nativex.hint.NativeHint;
import org.springframework.nativex.hint.TypeHint;

import lombok.RequiredArgsConstructor;
import picocli.CommandLine;
import picocli.CommandLine.IFactory;

@TypeHint(types = Mode.class, typeNames = "com.bonita.iht.iht.Mode$ModeOption")
@SpringBootApplication
@RequiredArgsConstructor
public class IhtApplication implements CommandLineRunner, ExitCodeGenerator {

    private final IFactory factory;
    private final TruthTellerCommand command;
    private int exitCode;

    public static void main(String[] args) {
        System.exit(SpringApplication.exit(SpringApplication.run(IhtApplication.class, args)));
    }

    @Override
    public void run(String... args) {
        // let picocli parse command line args and run the business logic

        exitCode = new CommandLine(command, factory).execute(args);
    }

    @Override
    public int getExitCode() {
        return exitCode;
    }

}
