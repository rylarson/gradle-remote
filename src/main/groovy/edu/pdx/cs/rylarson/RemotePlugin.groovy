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
        addRemoteConfiguration(project)
        addMavenCentral(project)
        addJschDependencies(project)
        addTasksToProject(project)
        defineAntTasks(project)
    }

    private void addRemoteConfiguration(Project project) {
        project.configurations.create("remote")
    }

    private void addMavenCentral(Project project) {
        project.repositories.add(project.repositories.mavenCentral())
    }

    private void addJschDependencies(Project project) {
        project.dependencies.add("remote", "org.apache.ant:ant-jsch:+")
        project.dependencies.add("remote", "com.jcraft:jsch:+")
    }

    private void addTasksToProject(Project project) {
        project.task('scp', type: Scp)
        project.task('ssh', type: Ssh)
    }

    private void defineAntTasks(Project project) {
        project.ant.taskdef(
                name: 'ssh',
                classname: 'org.apache.tools.ant.taskdefs.optional.ssh.SSHExec',
                classpath: project.configurations.remote.asPath
        )
        project.ant.taskdef(
                name: 'scp',
                classname: 'org.apache.tools.ant.taskdefs.optional.ssh.Scp',
                classpath: project.configurations.remote.asPath
        )
    }
}
