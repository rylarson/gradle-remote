package edu.pdx.cs.rylarson

import edu.pdx.cs.rylarson.scp.ScpTask
import edu.pdx.cs.rylarson.ssh.SshTask
import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import org.junit.Test

import static org.testng.Assert.assertNull
import static org.testng.Assert.assertTrue

/**
 * Created with IntelliJ IDEA.
 * User: Ryan
 * Date: 8/6/13
 * Time: 6:07 PM
 * To change this template use File | Settings | File Templates.
 */
class RemotePluginTests {

    @Test
    void testRemotePluginAddsSshTaskToProject() {
        Project project = ProjectBuilder.builder().build()
        assertNull(project.tasks.find { it.name == 'SshTask' })

        project.apply plugin: RemotePlugin
        assertTrue(project.tasks.find { it.name == 'SshTask' } instanceof SshTask)
    }

    @Test
    void testRemotePluginAddsScpTaskToProject() {
        Project project = ProjectBuilder.builder().build()
        assertNull(project.tasks.find { it.name == 'ScpTask' })

        project.apply plugin: RemotePlugin
        assertTrue(project.tasks.find { it.name == 'ScpTask' } instanceof ScpTask)
    }
}