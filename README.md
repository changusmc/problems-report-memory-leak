# Multi-Module Android Memory Leak Reproduction

This project reproduces the memory leak issue with KSP tasks, KAPT processing, and Gradle's dependency resolution cache in a realistic multi-module Android project.

## The Problem

The memory leak manifests as:
- 526 instances of `kotlinx.serialization.json.JsonObject` consuming 724MB
- `VariantArtifactSetCache` holding onto `ConcurrentHashMap` entries
- `ThisBuildTreeOnlyComponentResultSerializer` retaining 10.7MB
- Thread-local variables in execution workers not being cleaned up
- KSP and KAPT annotation processor memory leaks
- **Configuration cache incompatibility** with `buildFinished` listeners

## How to Reproduce

1. **Generate modules and run the test**:
   ```bash
   ./test-memory-leak.sh
   ```

2. **Or run manually**:
   ```bash
   # Generate 20 Android modules
   ./gradlew generateModules --no-configuration-cache
   
   # Test with configuration cache (shows memory leak)
   ./gradlew clean kspDebugKotlin --configuration-cache
   
   # Test without configuration cache
   ./gradlew clean kspDebugKotlin --no-configuration-cache
   ```

3. **Generate heap dump**:
   ```bash
   # Add -XX:+HeapDumpOnOutOfMemoryError to gradle.properties
   # Or use jmap to generate heap dump during build
   jmap -dump:format=b,file=heap.hprof <gradle-daemon-pid>
   ```

## Key Memory Leak Indicators

When running the tests, look for these specific error messages:

1. **Configuration Cache Error**:
   ```
   Build file 'build.gradle': line 57: registration of listener on 'Gradle.buildFinished' is unsupported
   ```

2. **Deprecated API Warning**:
   ```
   The deprecated "gradleEnterprise.buildScan.buildScanPublished" API has been replaced by "develocity.buildScan.buildScanPublished"
   ```

3. **Multiple KSP Tasks**: 20 modules × KSP processing = memory pressure

## Project Structure

- **20 Android library modules** to simulate a large multi-module project
- **KSP processing** with Dagger on each module to trigger the memory leak
- **KAPT processing** with Java classes on each module
- **Build scan plugin** to reproduce the `buildFinished` listener memory leak
- **Multiple Android dependencies** to create dependency resolution work
- **Realistic Android project structure** with Activities, Services, and Resources

## Expected Memory Leak Pattern

When analyzing the heap dump, look for:
1. `VariantArtifactSetCache` with large `ConcurrentHashMap`
2. `ThisBuildTreeOnlyComponentResultSerializer` retaining memory
3. Multiple `JsonObject` instances from dependency metadata
4. Thread-local variables in execution workers
5. KSP and KAPT annotation processor memory leaks
6. Android-specific dependency resolution cache leaks

## Gradle Version

- Gradle: 8.13
- Android Gradle Plugin: 8.3.2
- Kotlin: 2.0.21
- KSP: 2.0.21-1.0.26
- Dagger: 2.51.1

## Root Cause

The memory leak is caused by:
1. **`buildFinished` listeners** that are incompatible with configuration cache
2. **KSP tasks** holding onto dependency resolution cache
3. **Thread-local variables** in execution workers not being cleaned up
4. **Multiple annotation processors** running simultaneously across many modules

## Related Issues

- Gradle Issue #8142: Custom attribute types memory leak
- Gradle Issue #30654: Configuration cache memory usage
- Gradle Issue #23215: High memory usage in complex projects
- KSP Issue #1698: Memory leak in KSP tasks
