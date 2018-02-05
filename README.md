# Test Setup

## Setup:

### IDE
- Install the ide of your choice, which supports java and Gauge. One option is to install Intellij Community Edition
- Add the Gauge plugin to the IDE
<br> [Gauge Intellij plugin](https://plugins.jetbrains.com/plugin/7535) (optional, but recommended). More information on plugin can be found [here](http://getgauge.io/documentation/user/current/ide_support/intellij_idea.html)

### Platform Installations
- Install Java JDK 8 on your machine
- Install maven on your machine
- [Install Gauge](http://getgauge.io/download.html)
  Install Gauge version 0.9.5
  
- [Install Gauge-Java plugin](http://getgauge.io/documentation/user/current/plugins/installation.html) by executing the command
  gauge install java --version 0.6.5
  
- [Install Gauge-HTML plugin](http://getgauge.io/documentation/user/current/plugins/installation.html) by executing the command
  gauge install html-report --version 3.1.0
  
### Running test though IDE
1. Go to spec/redditAssignment.spec
2. Click on left side green play button of any spec you want to run
3. Select "Run redditAssignment.htm..."
4. Test will start executing
5. Once test gets complete, you can see result in the "report/index.html"
