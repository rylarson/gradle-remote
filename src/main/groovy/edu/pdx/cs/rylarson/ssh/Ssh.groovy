package edu.pdx.cs.rylarson.ssh

/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2013 Ryan Larson
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

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
