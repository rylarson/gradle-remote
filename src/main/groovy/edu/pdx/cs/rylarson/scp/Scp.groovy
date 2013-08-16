package edu.pdx.cs.rylarson.scp

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

class Scp extends DefaultTask {

    def file, localFile, remoteFile, todir, localTodir, localTofile,
        remoteTodir, remoteTofile, port, trust, knownhosts, failonerror, password,
        keyfile, passphrase, verbose, sftp, preserveLastModified

    @TaskAction
    def scp() {
        ant.scp(scpArguments)
    }

    //get any properties set by the user, otherwise use the defaults
    def getScpArguments() {
        return [
                file: file,
                localFile: localFile,
                remoteFile: remoteFile,
                todir: todir,
                localTodir: localTodir,
                localTofile: localTofile,
                rempoteTodir: remoteTodir,
                remoteTofile: remoteTofile,
                port: port,
                trust: trust,
                knownhosts: knownhosts,
                failonerror: failonerror,
                password: password,
                keyfile: keyfile,
                passphrase: passphrase,
                verbose: verbose,
                sftp: sftp,
                preserveLastModified: preserveLastModified
        ].findAll { it.value }
    }
}
