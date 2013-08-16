package edu.pdx.cs.rylarson

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

import edu.pdx.cs.rylarson.scp.Scp
import edu.pdx.cs.rylarson.ssh.Ssh
import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import org.junit.Test

import static org.testng.Assert.assertNull
import static org.testng.Assert.assertTrue

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
