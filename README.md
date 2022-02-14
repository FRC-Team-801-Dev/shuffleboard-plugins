# shuffleboard-plugins
A repository for various Shuffleboard extensions to suit our development needs.

## Deploying
Run `gradlew :plugin-name:installPlugin` to build the plugin and add it to Shuffleboard.

## Making Your Own Plugin
To use `generic-plugin` as a template (replace `plugin-name` with the name of your plugin):
1. Make a copy of the entire `generic-plugin` folder.
1. Change the name of the new folder to `plugin-name`.
1. Open `settings.gradle` in VSCode.
1. Add a newline with the text `include('plugin-name')` to the bottom of `settings.gradle`.
1. Save the `settings.gradle` file.
1. Change the name of `plugin-name/src/main/java/com/shuffleboard/plugins/GenericPlugin` to `PluginName`.
1. Open `PluginName.java` and change the name of the `GenericPlugin` java class to `PluginName`.
1. Update the `@Description` annotation to properly describe your plugin.

See [docs.wpilib.org](https://docs.wpilib.org/en/stable/docs/software/dashboards/shuffleboard/custom-widgets/creating-custom-data-types.htmlhttps://docs.wpilib.org/en/stable/docs/software/dashboards/shuffleboard/index.html) for more info on Shuffleboard behavior.