package com.example

import com.vexillum.plugincore.PluginCoreBase
import com.vexillum.plugincore.PluginCoreBoot

class ExamplePlugin : PluginCoreBase() {

    override fun enable() {
        logManager.info("${plugin.name} is now enabled")
    }
}

class Main : PluginCoreBoot(ExamplePlugin())
