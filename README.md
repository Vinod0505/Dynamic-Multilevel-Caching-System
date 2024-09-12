# Dynamic Multilevel Caching System

## Objective
This project implements a dynamic multilevel caching system designed to manage data efficiently across multiple cache levels. The system supports dynamic addition and removal of cache levels, and includes eviction policies such as Least Recently Used (LRU) and Least Frequently Used (LFU).

## Project Structure
- **Package**: `com.capx.dmcs`
  - **CacheEntry.java**: Defines the basic structure of a cache entry with a key and value.
  - **CacheLevel.java**: An abstract class for different cache levels.
  - **LRUCacheLevel.java**: Implements LRU eviction policy for a cache level.
  - **LFUCacheLevel.java**: Implements LFU eviction policy for a cache level.
  - **MultilevelCache.java**: Manages multiple cache levels and handles data insertion, retrieval, and eviction.
  - **CacheSystemTest.java**: Contains test cases to demonstrate cache operations.

## Key Features
- **Multilevel Cache**: Organizes multiple cache levels (L1, L2, ..., Ln) by priority. Data is inserted into the highest-priority level (L1).
- **Eviction Policies**:
  - **LRU**: Evicts the least recently accessed item.
  - **LFU**: Evicts the least frequently accessed item.
- **Dynamic Cache Management**: Allows adding or removing cache levels at runtime.
- **Data Promotion**: Moves data to higher cache levels upon retrieval from lower levels.

## How It Works
1. **Cache Levels**: Cache levels are added dynamically with specified sizes and eviction policies.
2. **Data Retrieval**: Retrieves data from the highest-priority cache level (L1) first. If data is not found, it searches lower levels. Data is promoted to L1 upon retrieval from lower levels.
3. **Data Insertion**: Inserts data into L1 cache and evicts items based on the eviction policy when necessary.

## How to Run
1. **Clone the Repository**: Clone the project to your local environment.
2. **Compile the Code**: Ensure JDK is installed, then compile the Java files:
   ```bash
   javac src/com/capx/dmcs/*.java

   Run the CacheSystemTest Class: Execute the CacheSystemTest class:
bash
java com.capx.dmcs.CacheSystemTest
