# Java Spring Developer Assignment

## Project Overview
This project implements a REST API for a voting system using Java and Spring Boot. The API allows users to add candidates, cast votes, retrieve vote counts, list all candidates with their votes, and find the candidate with the highest votes.

## API Endpoints
1. **Enter Candidate** - `/api/entercandidate?name={name}`
   - Adds a new candidate with an initial vote count of 0.

2. **Cast Vote** - `/api/castvote?name={name}`
   - Casts a vote for the specified candidate.

3. **Count Vote** - `/api/countvote?name={name}`
   - Returns the current vote count for the specified candidate.

4. **List Votes** - `/api/listvote`
   - Lists all candidates and their current vote counts.

5. **Get Winner** - `/api/getwinner`
   - Returns the candidate with the highest vote count.

## Setup Instructions
1. Clone the repository.
2. Open the project in an IDE (e.g., IntelliJ, Eclipse).
3. Make sure to have Java and Maven installed.
4. Run the application by executing the `VotingApplication` class.
5. Use a tool like Postman or a browser to access the API endpoints.

## Features Implemented
- In-memory storage with thread-safe operations.
- REST API with endpoints for managing and voting for candidates.
- Unit tests for each service method.
