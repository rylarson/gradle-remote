package edu.pdx.cs.rylarson.scp

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

/**
 * Created with IntelliJ IDEA.
 * User: Ryan
 * Date: 8/6/13
 * Time: 6:20 PM
 * To change this template use File | Settings | File Templates.
 */
class ScpTask extends DefaultTask {

    def file, localFile, remoteFile, todir, localTodir, localTofile,
        remoteTodir, port, trust, knownhosts, failonerror, password,
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
