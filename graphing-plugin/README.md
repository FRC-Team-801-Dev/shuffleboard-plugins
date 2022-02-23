# Generic Plugin
To use this template (replace `plugin-name` with the name of your plugin):
1. Make a copy of the entire directory `generic-plugin`.
2. Change the name of the new directory to `plugin-name`.
3. Add `include('plugin-name')` to the bottom of `settings.gradle`
4. Change the name of `plugin-name/src/main/java/com/shuffleboard/plugins/GenericPlugin.java` to `PluginName.java`.
5. Change the name of the `GenericPlugin` java class to `PluginName`.
6. Update the `@Description` annotation to properly describe your plugin.