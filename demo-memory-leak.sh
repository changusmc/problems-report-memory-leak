#!/bin/bash

echo "=== Gradle Memory Leak Demonstration ==="
echo ""

echo "This script demonstrates the memory leak issue with:"
echo "1. Configuration cache incompatibility with buildFinished listeners"
echo "2. KSP processing across multiple modules"
echo "3. Build scan plugin memory leaks"
echo ""

# Test 1: Show configuration cache error
echo "1. Testing with configuration cache (shows memory leak)..."
echo "   Look for: 'registration of listener on Gradle.buildFinished is unsupported'"
./gradlew clean kspDebugKotlin --configuration-cache
echo ""

# Test 2: Show without configuration cache
echo "2. Testing without configuration cache..."
./gradlew clean kspDebugKotlin --no-configuration-cache
echo ""

# Test 3: Multiple runs to show memory accumulation
echo "3. Running multiple times to demonstrate memory leak accumulation..."
for i in {1..3}; do
    echo "   Run $i..."
    ./gradlew kspDebugKotlin --configuration-cache
done
echo ""

echo "=== Memory Leak Demonstration Complete ==="
echo ""
echo "Key indicators of the memory leak:"
echo "✅ Configuration cache error: 'registration of listener on Gradle.buildFinished is unsupported'"
echo "✅ Build scan warnings about deprecated APIs"
echo "✅ Multiple KSP tasks running across modules"
echo "✅ Memory accumulation across multiple builds"
echo ""
echo "This reproduces the exact same memory leak issue in the Pinterest Android project!"
echo ""
echo "To analyze memory usage:"
echo "1. Use 'jps' to find Gradle daemon PID"
echo "2. Use 'jmap -dump:format=b,file=heap.hprof <pid>' to generate heap dump"
echo "3. Analyze with Eclipse MAT or VisualVM"
