package com.bonita.iht.la;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bonitasoft.web.designer.ArtifactBuilderFactory;
import org.bonitasoft.web.designer.config.UiDesignerPropertiesBuilder;
import org.springframework.stereotype.Component;
import picocli.CommandLine;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

@Slf4j
@Component
@CommandLine.Command(name = "page-build")
public class BuildPageCommand implements Runnable {


    @CommandLine.Option(names = {"-w", "--workspace"})
    String workspace;

    @CommandLine.Option(names = {"-o", "--output"})
    String output;

    @CommandLine.Option(names = {"-p", "--page"})
    String pageId;

    @Override
    public void run() {
        log.info("Building page {} from {}, output: {}", pageId, workspace, output);
        var properties = new UiDesignerPropertiesBuilder()
                .workspacePath(Path.of(workspace))
                .build();
        var artifactBuilder = new ArtifactBuilderFactory(properties).create();
        try {
            var zip = artifactBuilder.buildPage(pageId);
            Files.write(Path.of(output), zip, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
            log.info("Page buid success, output: {}", output);
        } catch (Exception e) {
            throw new RuntimeException("Failed to build page", e);
        }
    }
}
