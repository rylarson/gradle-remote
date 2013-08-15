package edu.pdx.cs.rylarson

import edu.pdx.cs.rylarson.ssh.Ssh
import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import org.junit.Test

/**
 * Created with IntelliJ IDEA.
 * User: Ryan
 * Date: 8/6/13
 * Time: 6:41 PM
 * To change this template use File | Settings | File Templates.
 */
class RemotePluginIntegrationTests {

    @Test
    void testSshTaskUsingPassword(){
        Project project = ProjectBuilder.builder().build()
        project.task('SshTask', type: Ssh)

    }
}
