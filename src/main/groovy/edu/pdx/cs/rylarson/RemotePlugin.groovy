package edu.pdx.cs.rylarson

import edu.pdx.cs.rylarson.scp.Scp
import edu.pdx.cs.rylarson.ssh.Ssh
import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * Created with IntelliJ IDEA.
 * User: Ryan
 * Date: 7/31/13
 * Time: 10:11 PM
 * To change this template use File | Settings | File Templates.
 */
class RemotePlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        addTasksToProject(project)
        defineAntTasks(project)
    }

    private void addTasksToProject(Project project) {
        project.task('scp', type: Scp)
        project.task('ssh', type: Ssh)
    }

    private void defineAntTasks(Project project) {
        project.ant.taskdef(
                name: 'ssh',
                classname: 'org.apache.tools.ant.taskdefs.optional.ssh.SSHExec',
                classpath: project.buildscript.configurations.classpath.asPath
        )
        project.ant.taskdef(
                name: 'scp',
                classname: 'org.apache.tools.ant.taskdefs.optional.ssh.Scp',
                classpath: project.buildscript.configurations.classpath.asPath
        )
    }
}
