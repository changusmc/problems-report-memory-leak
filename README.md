# Multi-Module Kotlin Memory Leak Investigation

This project investigates the `VisitableURLClassLoader` memory leak in a multi-module Gradle project, even after converting from Android to pure Kotlin libraries.

## Problem

<img width="1538" height="793" alt="image" src="https://github.com/user-attachments/assets/4fff745b-681a-4432-9092-50812425daaf" />

**The Issue:**
- **54.8MB retained heap** in `DefaultRootBuildState` and related Gradle infrastructure
- `ConfigurationCacheFingerprintController` holding onto large object graphs
- `DefaultListenerManager` retaining 54.9MB through event listener chains
- `ProblemsProgressEventEmitterHolder` with 2,263,696 bytes in object arrays
- `VisitableURLClassLoader` consuming 3.4MB across multiple threads
- Thread-local variables in execution workers not being cleaned up
- **Configuration cache incompatibility** with `buildFinished` listeners

## How to Reproduce the Memory Leak

1. **Run the build**:
   ```bash
   # Build all modules 
   ./gradlew clean build
   ```

2. **Generate heap dump**:
   ```bash
   # Add -XX:+HeapDumpOnOutOfMemoryError to gradle.properties
   # Or use jmap to generate heap dump during build
   jmap -dump:format=b,file=heap.hprof <gradle-daemon-pid>
   ```

## Project Structure

- **10 Kotlin JVM library modules** (module0-module9) - Still causing memory leaks
- **1 Kotlin JVM application** (app) - Entry point
- **Pure Kotlin dependencies** - No Android complexity
- **Multi-module Gradle build** - Still problematic

## Technical Details

### Versions Used
- **Gradle**: 9.1.0
- **Kotlin**: 2.0.21
- **Kotlin Serialization**: 2.0.21
- **Java**: 21 (JVM Toolchain)
- **Kotlinx Coroutines**: 1.7.3
- **Kotlinx Serialization**: 1.6.0
- **Ktor**: 2.3.7

### Build Configuration
- **Pure Kotlin JVM libraries** - No Android dependencies
- **Java 21 compatibility** - Modern JVM features
- **Kotlin JVM toolchain** - Consistent compilation
- **Serialization support** - JSON processing
- **Coroutines support** - Async programming

## Investigation Results

**Converting from Android to Kotlin libraries did NOT solve the memory leak:**

1. **Android Gradle Plugin removed** - But memory leak persists
2. **Pure Kotlin JVM libraries** - Still causing `VisitableURLClassLoader` retention
3. **Multi-module Gradle builds** - Still problematic regardless of language
4. **Gradle dependency resolution** - Still causing memory leaks
5. **Configuration cache issues** - Still incompatible with multi-module builds

## Conclusion

❌ **Memory leak NOT solved** - `VisitableURLClassLoader` retention still present  
❌ **Multi-module builds still problematic** - Gradle build system still causing issues  
❌ **Configuration cache still incompatible** - Multi-module builds still problematic  
❌ **Root cause not eliminated** - The issue is with Gradle's multi-module build system, not Android
