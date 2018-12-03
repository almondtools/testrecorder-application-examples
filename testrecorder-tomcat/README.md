# testrecorder-tomcat

This is an example servlet deployable to a tomcat with servlet specification 3.0.

Configure your tomcat
* add the following to the tomcat class path: `<path\to\testrecorder-tomcat-config>\target\classes`
* add the following to tomcat start arguments: `-javaagent:<path\to\repositorylocation>\testrecorder-agent-<version>-agent.jar=<path\to\testrecorder-tomcat-config>\src\main\config\agentconfig`

A successful startup will 
* start with the log `loading SerializationProfile` 
* and will contain the log line `recording snapshots of net/amygdalum/testrecorder/appexamples/tomcat/servlet/TodoList`

The recorded method is `TodoList.add(Integer, String)` and can be found in [TodoList.java](https://github.com/almondtools/testrecorder-application-examples/blob/master/testrecorder-tomcat/src/main/java/net/amygdalum/testrecorder/appexamples/tomcat/servlet/TodoList.java).

After startup navigate to your application, e.g. `localhost:8080/testrecorder-tomcat/`. Notice the log lines:
* `writing tests to <path\to\testrecorder-tomcat>\target\generated\com\almondtools\testrecorder\appexamples\tomcat\servlet\TodoList0Test.java`
* `writing tests to <path\to\testrecorder-tomcat>\target\generated\com\almondtools\testrecorder\appexamples\tomcat\servlet\TodoList2Test.java`


You may then experiment with url parameters, e.g.:
* `?action=add&name=Take the dog out`
* `?action=insert&id=2&name=Wake up the children`
* `?action=remove&id=1`