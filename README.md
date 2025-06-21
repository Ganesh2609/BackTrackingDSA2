# Backtracking Algorithms Collection

A comprehensive implementation of classic backtracking algorithms solving fundamental computer science problems including N-Queens, Knight's Tour, Maze Navigation, and Sudoku puzzles.

## Overview

This repository contains optimized implementations of four classic backtracking problems, demonstrating the power and elegance of recursive problem-solving techniques. Each implementation showcases different aspects of backtracking algorithms, from constraint satisfaction to pathfinding.

## Theory and Algorithms

**Backtracking** is a systematic method for solving constraint satisfaction problems by incrementally building candidates to solutions and abandoning candidates ("backtracking") when they cannot lead to a valid solution.

### Key Concepts:
- **State Space Tree**: Represents all possible states of the problem
- **Pruning**: Eliminating branches that cannot lead to solutions
- **Constraint Propagation**: Applying constraints to reduce search space
- **Solution Construction**: Building solutions incrementally

## Implemented Algorithms

### 1. N-Queens Problem
Solves the classic N-Queens puzzle where N queens must be placed on an N×N chessboard such that no two queens attack each other.

**Algorithm Features:**
- Constraint checking for row, column, and diagonal conflicts
- Optimized diagonal validation using mathematical formulas
- Complete enumeration of all possible solutions

### 2. Knight's Tour
Finds all possible paths for a knight to visit every square on an N×N chessboard exactly once.

**Algorithm Features:**
- L-shaped movement pattern implementation
- Boundary checking and collision detection
- Complete tour enumeration with step tracking

### 3. Maze Solver
Navigates through a maze from top-left to bottom-right corner, finding all possible paths.

**Algorithm Features:**
- 4-directional movement (Up, Down, Left, Right)
- Path tracking with step numbering
- Multiple solution discovery
- Direction encoding (U/D/L/R)

### 4. Sudoku Solver
Solves 9×9 Sudoku puzzles using constraint satisfaction principles.

**Algorithm Features:**
- Row, column, and 3×3 box constraint validation
- GUI input interface (Java version)
- Console-based input/output (C version)
- Comprehensive input validation

## Project Structure

```
├── Knight_Tour.java     # Knight's tour problem solver
├── Nqueens.java        # N-Queens problem implementation
├── Maze.java           # Maze pathfinding algorithm
├── Sudoku.java         # Sudoku solver with GUI
├── Sudoku.c            # Sudoku solver (C implementation)
└── README.md           # Project documentation
```

## Implementation Details

### Java Implementations
- **Thread Extension**: All Java classes extend Thread for potential parallel execution
- **Scanner Input**: Interactive console input for problem parameters
- **Array Visualization**: Clear display of solutions and intermediate states
- **Error Handling**: Input validation and boundary checking

### C Implementation
- **Memory Efficient**: Optimized for performance with minimal memory overhead
- **Robust Input Validation**: Comprehensive error checking for user inputs
- **Standard I/O**: Clean console interface for puzzle input and solution display

## Features

- **Complete Solution Enumeration**: Finds and displays all possible solutions
- **Interactive Input**: User-friendly interfaces for problem configuration
- **Visual Output**: Clear representation of solutions and paths
- **Performance Tracking**: Solution counting and execution feedback
- **Cross-Language Support**: Both Java and C implementations available

## Usage Examples

### Running N-Queens
```bash
javac Nqueens.java
java Nqueens
# Enter board size when prompted
```

### Running Sudoku Solver
```bash
javac Sudoku.java
java Sudoku
# Use GUI to input puzzle values
```

### Running Knight's Tour
```bash
javac Knight_Tour.java
java Knight_Tour
# Enter board size for tour calculation
```

## Algorithm Complexity

- **Time Complexity**: Exponential O(N!) for most problems due to exhaustive search
- **Space Complexity**: O(N²) for board representation and O(N) for recursion stack
- **Optimization**: Constraint checking reduces practical runtime significantly

## Key Learning Outcomes

- Understanding recursive problem decomposition
- Implementing constraint satisfaction algorithms
- Managing state space exploration efficiently
- Applying pruning techniques for optimization
- Handling complex combinatorial problems