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
import org.gradle.api.Plugin
import org.gradle.api.Project

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
