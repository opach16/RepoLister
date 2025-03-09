# RepoLister

RepoLister is a simple API application built using Quarkus that fetches public repositories and their associated branches for a given GitHub user. It offers an easy-to-use endpoint to get repository details and branch information, including the branch name and the last commit SHA.

## Features:

- Fetches all public repositories that are not forks for a given GitHub user.
- Lists all branches for each repository.
- Provides the last commit SHA for each branch.
- Simple and fast response with detailed repository and branch information.

## Installation and Setup

**Prerequisites:**

- JDK 17 or higher.
- Maven 3.6+ (for building the application).
- Quarkus CLI (optional)

## Installation

**Clone the repository:**
```
git clone https://github.com/opach16/RepoLister.git
cd repolister
```

**Build the application:**
```
./mvnw clean install
```

**Run the application:**
```
./mvnw quarkus:dev
```

## Usage

Once the application is running, you can access the repository information for any GitHub user by visiting the following endpoint:

**Endpoint:**
```
GET http://localhost:8080/repo/{username}
```
Replace `{username}` with the GitHub username you want to query.

**Example Request:**
```
GET http://localhost:8080/repo/opach16
```
**Example Response:**
```
[
    {
        "repository_name": "SmartFinance",
        "owner_login": "opach16",
        "branch": [
            {
                "branch_name": "main",
                "commit_sha": "bcde84f70bed888030fdd0c5cc8efa25faf1b261"
            }
        ]
    },
    {
        "repository_name": "RepoLister",
        "owner_login": "opach16",
        "branch": [
            {
                "branch_name": "main",
                "commit_sha": "b6a3d9f627530f7ca662b0b6e5eda4be2baeb6f2"
            }
        ]
    }
]
```

## Technologies Used:
- **Quarkus:** Java framework optimized for containerized environments, providing fast startup times and low memory usage.
- **GitHub API:** Used to fetch public repositories and their branches.
- **Maven:** Build tool for managing dependencies and packaging the application.
