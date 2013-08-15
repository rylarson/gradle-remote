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

    def file
    def localFile
    def remoteFile
    def todir
    def localTodir
    def localTofile
    def remoteTodir
    def port = 22
    def trust = false
    //def knownhosts = "${user.home}/.SshTask/known_hosts"
    def failonerror = true
    def password
    def keyfile
    def passphrase = ""
    def verbose = false
    def sftp = false
    def preserveLastModified = false

    @TaskAction
    def antScp() {
        ant.scp(scpProperties)
    }

    def getScpProperties() {
        def declaredFields = [this.class.declaredFields.findAll { !it.synthetic }]
        return properties.findAll { declaredFields.contains(it.key) && it.value }
    }
}
