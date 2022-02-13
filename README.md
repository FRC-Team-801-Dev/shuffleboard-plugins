# shuffleboard-plugins
A repository for various Shuffleboard extensions to suit our development needs.

## Deploying
Run `gradlew :plugin-name:installPlugin` to build the plugin and add it to Shuffleboard.

## Making Your Own Plugin
To use `generic-plugin` as a template (replace `plugin-name` with the name of your plugin):
1. Make a copy of the entire directory `generic-plugin`.
2. Change the name of the new directory to `plugin-name`.
3. Add `include('plugin-name')` to the bottom of `settings.gradle`
4. Change the name of `plugin-name/src/main/java/com/shuffleboard/plugins/GenericPlugin.java` to `PluginName.java`.
5. Change the name of the `GenericPlugin` java class to `PluginName`.
6. Update the `@Description` annotation to properly describe your plugin.

See [docs.wpilib.org](https://docs.wpilib.org/en/stable/docs/software/dashboards/shuffleboard/custom-widgets/creating-custom-data-types.htmlhttps://docs.wpilib.org/en/stable/docs/software/dashboards/shuffleboard/index.html) for more info on Shuffleboard behavior.