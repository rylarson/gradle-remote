gradle-remote
=============

[![Build Status](https://buildhive.cloudbees.com/job/rylarson/job/gradle-remote/badge/icon)](https://buildhive.cloudbees.com/job/rylarson/job/gradle-remote/)

This plugin allows you to interact with remote hosts from gradle.

The first iteration will allow copying files via scp and executing 
remote commands over ssh. The plugin will eventually be configurable
to allow the use of different protocols like psexec, etc.

#### Usage

Applying the Remote plugin will add Ssh and Scp task types to the project. 

```groovy
import edu.cs.pdx.rylarson.RemotePlugin

apply plugin: RemotePlugin

task sshTask(type: Ssh) {
  host = 'remote.example.com'
  user = 'user'
  password = 'password'
  command = 'uname -a'
}

task scpTask(type: Ssh) {
  localFile = file('testScp.txt')
  remoteTodir = user@host:~/todir
  password = 'password'
}
```


