# Plugin

Plugin Name: **WIP blocker**

# Purpose

The purpose of the plugin is to provide a merge check that prevents
merging a pull request in case a reviewer flags it using the _Needs Work_
button.

# Function

The Merge Check is implemented as a hook accessible under the
Merge Checks section in the Project/Repo admin UI

The plugin evaluates all Reviewer statuses and if there is at least
one **Needs work** status it will return **rejected**.
The Merge Check is configurable on both Project and Repository level,
following the same structure as the Bitbucket native Merge checks.

# Development

In order to rebuild the plugin use the Atlassian SDK

Here are the SDK commands you’ll use immediately:

-   atlas-run   – installs this plugin into the product and starts it on localhost
-   atlas-debug – same as atlas-run, but allows a debugger to attach at port 5005
-   atlas-cli   – after atlas-run or atlas-debug, opens a Maven command line window:
    \- ‘pi’ reinstalls the plugin into the running product instance
-   atlas-help  – prints description for all commands in the SDK

Full documentation is always available at:

[https://developer.atlassian.com/display/DOCS/Introduction+to+the+Atlassian+Plugin+SDK](https://developer.atlassian.com/display/DOCS/Introduction+to+the+Atlassian+Plugin+SDK)
