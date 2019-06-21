# testrecorder-spring

This is an example spring boot application.

Prerequisites:
* clone `testrecorder-app-examples` (this project) into your workspace
* import `testrecorder-spring` into your workspace and run `mvn install`
* clone `testrecorder-custom-agent` (found [here](https://github.com/almondtools/testrecorder-custom-agent))
* import `testrecorder-custom-agent` into your workspace and run `mvn install`

Just start this application by
- running `net.amygdalum.testrecorder.appexamples.spring.TodoApplication`
- while adding `-javaagent:<path\to\repositorylocation>\testrecorder-custom-agent-<version>-agent.jar` to the command line arguments (version will probably be a snapshot)

A successful startup will 
* start with the log `loading CustomSerializationProfile` 
* and will contain the log line `recording snapshots of net/amygdalum/testrecorder/appexamples/spring/TodoList`

The recorded method is `TodoList.add(Integer, String)` and can be found in [TodoList.java](https://github.com/almondtools/testrecorder-application-examples/blob/master/testrecorder-spring/src/main/java/net/amygdalum/testrecorder/appexamples/spring/TodoList.java).

To watch the application go to the command line and try out commands like
* `a Take the dog out`
* `i 2 Wake up the children`
* `r 1` 