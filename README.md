
# sweetwaveforms_release_planer_portal

Spring Boot Version : `3.0.4`
Java Version : `19`


This project uses GitFlow as its branching model for version control. GitFlow is a popular branching strategy that allows for easy parallel development and release management. This README provides an overview of how GitFlow is used in this project and how you can contribute to it.

## Prerequisites

-   GitFlow plugin installed on your local machine or Git client that supports GitFlow commands.

## Getting Started

To get started with contributing to this project, follow these steps:

1.  Clone the repository to your local machine.

    bashCopy code

    `git clone <repository_url>`

2.  Initialize GitFlow for the repository.

    csharpCopy code

    `git flow init`

3.  Create a new feature branch to work on a new feature.

    cssCopy code

    `git flow feature start <feature_name>`

4.  Make changes to the code and commit them to the feature branch.

    sqlCopy code

    `git add .
    git commit -m "Added feature X"`

5.  Finish the feature and merge it back to the develop branch.

    cssCopy code

    `git flow feature finish <feature_name>`

6.  Create a new release branch for a new version of the project.

    sqlCopy code

    `git flow release start <version_number>`

7.  Make final changes to the code and commit them to the release branch.

    sqlCopy code

    `git add .
    git commit -m "Ready for release X"`

8.  Finish the release and merge it to both the master and develop branches.

    cssCopy code

    `git flow release finish <version_number>`

9.  Create a hotfix branch for fixing critical issues in the code.

    cssCopy code

    `git flow hotfix start <hotfix_name>`

10.  Fix the issue and commit the changes to the hotfix branch.

sqlCopy code

`git add .
git commit -m "Fixed critical issue X"`

11.  Finish the hotfix and merge it to both the master and develop branches.

cssCopy code

`git flow hotfix finish <hotfix_name>`

## Acknowledgments

-   [GitFlow Documentation](https://www.atlassian.com/git/tutorials/comparing-workflows/gitflow-workflow)
-   [GitFlow Cheat Sheet](https://danielkummer.github.io/git-flow-cheatsheet/)