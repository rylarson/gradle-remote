package edu.pdx.cs.rylarson.ssh

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

/**
 * Created with IntelliJ IDEA.
 * User: Ryan
 * Date: 8/6/13
 * Time: 5:58 PM
 * To change this template use File | Settings | File Templates.
 */
class Ssh extends DefaultTask {

    def host, username, command, commandResource, port, trust, knownhosts, failonerror, password,
        keyfile, passphrase, suppresssystemout, output, append, outputproperty,
        timeout, input, verbose, inputproperty, inputstring, usepty

    @TaskAction
    def ssh() {
        project.ant.ssh(sshArguments)
    }

    //get any properties set by the user, otherwise use the defaults
    def getSshArguments() {
        return [
                host: host,
                username: username,
                command: command,
                commandResource: commandResource,
                port: port,
                trust: trust,
                knownhosts: knownhosts,
                failonerror: failonerror,
                password: password,
                keyfile: keyfile,
                passphrase: passphrase,
                suppresssystemout: suppresssystemout,
                output: output,
                append: append,
                outputproperty: outputproperty,
                timeout: timeout,
                input: input,
                verbose: verbose,
                inputproperty: inputproperty,
                inputstring: inputstring,
                usepty: usepty
        ].findAll { it.value }
    }
}
