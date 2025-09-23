#!/bin/bash

echo "=== Multi-Module Android Memory Leak Reproduction Test ==="
echo ""

# Generate modules first
echo "0. Generating 20 Android modules..."
./gradlew generateModules --no-configuration-cache
echo ""

# Test 1: With configuration cache (should show memory leak)
echo "1. Testing with configuration cache (should show memory leak)..."
echo "   Look for: 'registration of listener on Gradle.buildFinished is unsupported'"
./gradlew clean kspDebugKotlin --configuration-cache
echo ""

# Test 2: Without configuration cache  
echo "2. Testing without configuration cache (should show different memory leak)..."
./gradlew clean kspDebugKotlin --no-configuration-cache
echo ""

# Test 3: Multiple runs to accumulate memory leak
echo "3. Running multiple times to accumulate memory leak..."
for i in {1..3}; do
    echo "Run $i..."
    ./gradlew kspDebugKotlin --configuration-cache
done
echo ""

echo "=== Memory Leak Test Complete ==="
echo ""
echo "Key indicators of the memory leak:"
echo "1. Configuration cache error: 'registration of listener on Gradle.buildFinished is unsupported'"
echo "2. Build scan warnings about deprecated 'gradleEnterprise.buildScan.buildScanPublished' API"
echo "3. Multiple KSP tasks running across 20 modules"
echo ""
echo "To analyze memory usage:"
echo "1. Use 'jps' to find Gradle daemon PID"
echo "2. Use 'jmap -dump:format=b,file=heap.hprof <pid>' to generate heap dump"
echo "3. Analyze with Eclipse MAT or VisualVM"
echo ""
echo "Look for:"
echo "- VariantArtifactSetCache with large ConcurrentHashMap"
echo "- ThisBuildTreeOnlyComponentResultSerializer retaining memory"
echo "- Multiple JsonObject instances from dependency metadata"
echo "- Thread-local variables in execution workers"
echo "- KSP and KAPT annotation processor memory leaks"
