package edu.pdx.cs.rylarson

import edu.pdx.cs.rylarson.scp.Scp
import edu.pdx.cs.rylarson.ssh.Ssh
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
        assertNull(project.tasks.find { it.name == 'ssh' })

        project.apply plugin: RemotePlugin
        assertTrue(project.tasks.find { it.name == 'ssh' } instanceof Ssh)
    }

    @Test
    void testRemotePluginAddsScpTaskToProject() {
        Project project = ProjectBuilder.builder().build()
        assertNull(project.tasks.find { it.name == 'scp' })

        project.apply plugin: RemotePlugin
        assertTrue(project.tasks.find { it.name == 'scp' } instanceof Scp)
    }
}
