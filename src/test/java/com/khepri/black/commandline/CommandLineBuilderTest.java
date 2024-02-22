package com.khepri.black.commandline;

import com.khepri.black.command.ICommand;
import com.khepri.black.services.systems.file.FileSystemServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

public class CommandLineBuilderTest {
    private ICommand command;
    private final String jsonPropertiesFilePath = "src/test/resources/application.json";

    @Test
    void command_properties_are_loaded_from_json_file() {
        command = new CommandLineBuilder()
                .getPropertiesFromJsonFile(jsonPropertiesFilePath)
                .build();

        assertNotNull(command.getProperties());
    }

    @Test
    void creates_root_command_for_application() {
        command = new CommandLineBuilder().build();
        assertInstanceOf(ICommand.class, command);
    }

    @Test
    void command_name_attribute_loaded_from_json_file() {
        Properties properties = new FileSystemServiceImpl().getPropertiesFromJsonFile(jsonPropertiesFilePath);

        String expected = properties.getProperty("name");
        assertNotNull(expected);

        command = new CommandLineBuilder()
                .getPropertiesFromJsonFile(jsonPropertiesFilePath)
                .build();

        String actual = command.getProperties().getProperty("name");
        assertNotNull(actual);

        assertEquals(expected, actual);
    }

    @Test
    void command_version_attribute_loaded_from_json_file() {
        Properties properties = new FileSystemServiceImpl().getPropertiesFromJsonFile(jsonPropertiesFilePath);

        String expected = properties.getProperty("version");
        assertNotNull(expected);

        command = new CommandLineBuilder()
                .getPropertiesFromJsonFile(jsonPropertiesFilePath)
                .build();

        String actual = command.getProperties().getProperty("version");
        assertNotNull(actual);

        assertEquals(expected, actual);
    }

    @Test
    void command_synopsis_attribute_loaded_from_json_file() {
        Properties properties = new FileSystemServiceImpl().getPropertiesFromJsonFile(jsonPropertiesFilePath);

        String expected = properties.getProperty("synopsis");
        assertNotNull(expected);

        command = new CommandLineBuilder()
                .getPropertiesFromJsonFile(jsonPropertiesFilePath)
                .build();

        String actual = command.getProperties().getProperty("synopsis");
        assertNotNull(actual);

        assertEquals(expected, actual);
    }

    @Test
    void command_description_attribute_loaded_from_json_file() {
        Properties properties = new FileSystemServiceImpl().getPropertiesFromJsonFile(jsonPropertiesFilePath);

        String expected = properties.getProperty("description");
        assertNotNull(expected);

        command = new CommandLineBuilder()
                .getPropertiesFromJsonFile(jsonPropertiesFilePath)
                .build();

        String actual = command.getProperties().getProperty("description");
        assertNotNull(actual);

        assertEquals(expected, actual);
    }

    @Test
    void sets_root_command_name_attribute_from_properties() {
        Properties properties = new FileSystemServiceImpl().getPropertiesFromJsonFile(jsonPropertiesFilePath);

        String expected = properties.getProperty("name");
        assertNotNull(expected);

        command = new CommandLineBuilder()
                .getPropertiesFromJsonFile(jsonPropertiesFilePath)
                .setRootCommandAttributesFromProperties()
                .build();

        String actual = command.getName();
        assertNotNull(actual);

        assertEquals(expected, actual);
    }

    @Test
    void sets_root_command_version_attribute_from_properties() {
        Properties properties = new FileSystemServiceImpl().getPropertiesFromJsonFile(jsonPropertiesFilePath);

        String expected = properties.getProperty("version");
        assertNotNull(expected);

        command = new CommandLineBuilder()
                .getPropertiesFromJsonFile(jsonPropertiesFilePath)
                .setRootCommandAttributesFromProperties()
                .build();

        String actual = command.getVersion();
        assertNotNull(actual);

        assertEquals(expected, actual);
    }

    @Test
    void sets_root_command_synopsis_attribute_from_properties() {
        Properties properties = new FileSystemServiceImpl().getPropertiesFromJsonFile(jsonPropertiesFilePath);

        String expected = properties.getProperty("synopsis");
        assertNotNull(expected);

        command = new CommandLineBuilder()
                .getPropertiesFromJsonFile(jsonPropertiesFilePath)
                .setRootCommandAttributesFromProperties()
                .build();

        String actual = command.getSynopsis();
        assertNotNull(actual);

        assertEquals(expected, actual);
    }

    @Test
    void sets_root_command_description_attribute_from_properties() {
        Properties properties = new FileSystemServiceImpl().getPropertiesFromJsonFile(jsonPropertiesFilePath);

        String expected = properties.getProperty("description");
        assertNotNull(expected);

        command = new CommandLineBuilder()
                .getPropertiesFromJsonFile(jsonPropertiesFilePath)
                .setRootCommandAttributesFromProperties()
                .build();

        String actual = command.getDescription();
        assertNotNull(actual);

        assertEquals(expected, actual);
    }
}
